package com.ruoyi.content.handle;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.content.domain.MusicUser;
import com.ruoyi.content.service.IMusicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class MusicUserUtils {
    @Autowired
    private IMusicUserService musicUserService;
    /*按照用户编码尾号数字，存储已经保存的用户编码*/
    private Set<String> MUSIC_USER_SET_1 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_2 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_3 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_4 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_5 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_6 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_7 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_8 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_9 = new HashSet<>();
    private Set<String> MUSIC_USER_SET_0 = new HashSet<>();

    //批量插入数据库，每一千条数据插入一次
    private static final int MAX_SIZE = 1000;
    private ArrayList<MusicUser> WAITING_SAVE_USER = new ArrayList<>(MAX_SIZE);

    public static void main(String[] args) {
        // 同时支持代理 HTTP/HTTPS 请求
        System.setProperty("proxyHost", "121.31.177.202");
        System.setProperty("proxyPort", "8123");

        MusicUserUtils musicUserUtils = new MusicUserUtils();
        musicUserUtils.start(new ArrayList<>());
    }

    /**
     * 思路：
     * 每次读取若干个种子id，分别查询关注用户列表
     * 查询完毕，将关注用户入库。这些种子id对应的记录，变更状态已使用
     * 再次读取出若干种子id,如此继续
     */
    public void start(ArrayList<String> userIdList) {
        if (userIdList == null || userIdList.size() == 0) {
            userIdList = this.getUserIdListFromDB("0");
            //初始化数据 从1开始
            if (userIdList.size() == 0) {
                userIdList.add("1");
            }
        }
        if (userIdList != null) {
            for (String userId : userIdList) {
                System.out.println("开始查询编码[" + userId + "]的关注列表");
                this.sleep(500);   //查询间隔1s 反封ip
//                this.getMusicFollowsById(userId);
                this.getMusicFollowsBatchById(userId);
            }
            //批次查询结束后，将缓存中的未处理的数据批量插入
            if (WAITING_SAVE_USER.size() != 0) {
                musicUserService.insertMusicUserBatch(WAITING_SAVE_USER);
                WAITING_SAVE_USER.clear();
            }
            //将完成的种子归置到已使用
            String[] array = userIdList.toArray(new String[userIdList.size()]);
            musicUserService.updateMusicUserUsed(array);
            //数组的最后一位数，作为下一次查询的开始
            String lastUserId = userIdList.get(userIdList.size() - 1);
            userIdList = this.getUserIdListFromDB(lastUserId);
            if (userIdList.size() > 0) {
//                this.sleep(1000);   //查询间隔1s 反封ip
                start(userIdList);
            }
        }
    }

    /**
     * 获取种子用户
     *
     * @param startUserId 开始查询的种子userId
     * @return
     */
    private ArrayList<String> getUserIdListFromDB(String startUserId) {
        ArrayList musicUserIdArr = new ArrayList();
        //从数据库中读取指定数量的未使用用户数据
        int stepNum = 100;
        musicUserIdArr = musicUserService.selectSeedMusicUserId(startUserId, stepNum);
        return musicUserIdArr;
    }

    /**
     * 查询关注列表
     *
     * @param userId
     */
    public void getMusicFollowsById(String userId) {
        if (!this.hasSaved(userId)) {
            String url = "https://music.163.com/api/user/getfollows/" + userId;
            String param = "offset=0&limit=1000&order=true";
            //请求获取关注列表
            String result = HttpUtils.sendGet(url, param);
            System.out.println(result);
            if (StringUtils.isNotEmpty(result)) {
                JSONObject jsonObject = JSONUtil.parseObj(result);
                System.out.println(jsonObject.toString());
                if (jsonObject.containsKey("code") && jsonObject.getInt("code") == 200) {
                    if (jsonObject.containsKey("follow")) {
                        JSONArray follows = jsonObject.getJSONArray("follow");
//                        System.out.println("读取到关注数：" + follows.size());
                        MusicUser musicUser;
                        for (Object follow : follows) {
                            if (follow == null) {
                                continue;
                            }
                            musicUser = this.convertToMusicUser((JSONObject) follow);
//                            System.out.println(JSONUtil.toJsonStr(musicUser));
                            //此处可以将已经保存过的用户编号缓存本地，每次保存之前进行一下查询，已存在的用户直接跳过，减少数据库的请求次数
                            if (!this.hasSaved(musicUser.getUserId())) {
                                //已存在的数据跳过，保存方法中实现
                                musicUserService.insertMusicUser(musicUser);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 查询关注列表(批量保存)
     *
     * @param userId
     */
    public void getMusicFollowsBatchById(String userId) {
        String url = "https://music.163.com/api/user/getfollows/" + userId;
        String param = "offset=0&limit=1000&order=true";
        //请求获取关注列表
        String result = HttpUtils.sendGet(url, param);
        System.out.println(result);
        if (StringUtils.isNotEmpty(result)) {
            JSONObject jsonObject = JSONUtil.parseObj(result);
            System.out.println(jsonObject.toString());
            if (jsonObject.containsKey("code") && jsonObject.getInt("code") == 200) {
                if (jsonObject.containsKey("follow")) {
                    JSONArray follows = jsonObject.getJSONArray("follow");
//                        System.out.println("读取到关注数：" + follows.size());
                    MusicUser musicUser;
                    int sumCount = 0;
                    for (Object follow : follows) {
                        if (follow == null) {
                            continue;
                        }
                        musicUser = this.convertToMusicUser((JSONObject) follow);
//                            System.out.println(JSONUtil.toJsonStr(musicUser));
                        //此处可以将已经保存过的用户编号缓存本地，每次保存之前进行一下查询，已存在的用户直接跳过，减少数据库的请求次数
                        if (!this.hasSaved(musicUser.getUserId())) {
                            sumCount++;
                            //已存在的数据跳过，保存方法中实现
                            WAITING_SAVE_USER.add(musicUser);
                            if (sumCount >= MAX_SIZE) {
                                musicUserService.insertMusicUserBatch(WAITING_SAVE_USER);
                                WAITING_SAVE_USER.clear();
                                sumCount = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * JSON对象转换成表对象
     *
     * @param obj
     * @return
     */
    private MusicUser convertToMusicUser(JSONObject obj) {
        MusicUser musicUser = new MusicUser();
        //用户编码
        String userId = obj.getStr("userId");
        musicUser.setUserId(userId);
        musicUser.setId(Long.valueOf(userId));
        //昵称
        String nickname = obj.getStr("nickname");
        musicUser.setNickname(nickname);
        //备注名称
        String remarkName = obj.getStr("remarkName");
        musicUser.setRemarkName(remarkName);
        //头像
        String avatarUrl = obj.getStr("avatarUrl");
        musicUser.setAvatar(avatarUrl);
        //名称拼音
        String py = obj.getStr("py");
        musicUser.setPy(py);
        //性别
        int gender = obj.getInt("gender");
        musicUser.setGender(gender);
        //动态数
        int eventCount = obj.getInt("eventCount");
        musicUser.setEventCount(eventCount);
        //关注数
        int followsCount = obj.getInt("follows");
        musicUser.setFollowCount(followsCount);
        //粉丝数
        int fanCount = obj.getInt("followeds");
        musicUser.setFanCount(fanCount);
        //个人签名
        String signature = obj.getStr("signature");
        musicUser.setSignature(signature);
        //歌手类型
        int authStatus = obj.getInt("authStatus");
        musicUser.setAuthStatus(authStatus);
        //用户类型
        int userType = obj.getInt("userType");
        musicUser.setUserType(userType);
        return musicUser;
    }

    /**
     * 判断当前用户是否已经保存过
     *
     * @param userId
     * @return true 已经保存 false 未保存
     */
    private Boolean hasSaved(String userId) {
        String lastStr = String.valueOf(userId.charAt(userId.length() - 1));
        int i = Integer.parseInt(lastStr);
        Boolean hasSaved = Boolean.FALSE;
        switch (i) {
            case 0:
                hasSaved = MUSIC_USER_SET_0.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_0.add(userId);
                }
                break;
            case 1:
                hasSaved = MUSIC_USER_SET_1.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_1.add(userId);
                }
                break;
            case 2:
                hasSaved = MUSIC_USER_SET_2.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_2.add(userId);
                }
                break;
            case 3:
                hasSaved = MUSIC_USER_SET_3.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_3.add(userId);
                }
                break;
            case 4:
                hasSaved = MUSIC_USER_SET_4.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_4.add(userId);
                }
                break;
            case 5:
                hasSaved = MUSIC_USER_SET_5.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_5.add(userId);
                }
                break;
            case 6:
                hasSaved = MUSIC_USER_SET_6.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_6.add(userId);
                }
                break;
            case 7:
                hasSaved = MUSIC_USER_SET_7.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_7.add(userId);
                }
                break;
            case 8:
                hasSaved = MUSIC_USER_SET_8.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_8.add(userId);
                }
                break;
            case 9:
                hasSaved = MUSIC_USER_SET_9.contains(userId) ? Boolean.TRUE : Boolean.FALSE;
                if (!hasSaved) {
                    MUSIC_USER_SET_9.add(userId);
                }
                break;

        }
        return hasSaved;
    }


    /**
     * 休眠
     */
    private void sleep(long millis) {
        //防止过于频繁访问被封ip，每批次间隔，休息30s
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
