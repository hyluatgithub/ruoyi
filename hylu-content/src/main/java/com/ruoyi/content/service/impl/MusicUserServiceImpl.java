package com.ruoyi.content.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.content.domain.MusicUser;
import com.ruoyi.content.mapper.MusicUserMapper;
import com.ruoyi.content.service.IMusicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户 服务层实现
 *
 * @author hylu
 * @date 2018-11-30
 */
@Service
public class MusicUserServiceImpl implements IMusicUserService {
    @Autowired
    private MusicUserMapper musicUserMapper;

    /**
     * 新增用户
     *
     * @param musicUser 用户信息
     * @return 结果
     */
    @Override
    public int insertMusicUser(MusicUser musicUser) {
        MusicUser musicUserSearch = new MusicUser();
        musicUserSearch.setUserId(musicUser.getUserId());
        List<MusicUser> musicUsers = this.selectMusicUserList(musicUserSearch);
        if (musicUsers == null || musicUsers.size() == 0) {
            return musicUserMapper.insertMusicUser(musicUser);
        }
        return 0;
    }

    /**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public MusicUser selectMusicUserById(Long id) {
        return musicUserMapper.selectMusicUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param musicUser 用户信息
     * @return 用户集合
     */
    @Override
    public List<MusicUser> selectMusicUserList(MusicUser musicUser) {
        return musicUserMapper.selectMusicUserList(musicUser);
    }

    /**
     * 删除用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMusicUserByIds(String ids) {
        return musicUserMapper.deleteMusicUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询指定区间的种子
     *
     * @param startId
     * @param stepNum
     * @return
     */
    @Override
    public ArrayList selectSeedMusicUserId(String startId, int stepNum) {
        if (stepNum == 0) {
            stepNum = 10;
        }
        return musicUserMapper.selectSeedMusicUserId(startId, stepNum);
    }

    /**
     * 更新种子用户为已使用
     *
     * @param ids 需要更新的数据userIds
     * @return 结果
     */
    @Override
    public int updateMusicUserUsed(String[] ids) {
        return musicUserMapper.updateMusicUserUsed(ids);
    }

}
