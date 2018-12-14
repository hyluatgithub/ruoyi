package com.ruoyi.content.handle;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.json.JSONUtil;
import com.oscroll.strawboat.assets.entity.IP;
import com.oscroll.strawboat.pool.ScheduledPool;
import com.ruoyi.common.utils.http.HttpUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ip代理类
 */
@Component
public class ProxyIPUtils {
    private static final int MAX_SIZE = 5;

    public static void createIPList() {
        ArrayList<IP> IP_ARR = new ArrayList<>();
        // 设置代理IP
        // 创建默认的IP池
        ScheduledPool pool = new ScheduledPool();
        // 在线程中启动IP池
        new Thread(pool::execute).start();

        AtomicInteger size = new AtomicInteger();
        // 从IP池中取出IP
        new Thread(() -> {
            while (size.get() < MAX_SIZE) {
                size.set(IP_ARR.size());
                IP ip = pool.take();
                System.out.println("1当前ip可用数量：" + size);
                System.out.println(JSONUtil.toJsonStr(ip));
                IP_ARR.add(ip);
            }
        }).start();
        // 从IP池中取出IP
        new Thread(() -> {
            while (size.get() < MAX_SIZE) {
                size.set(IP_ARR.size());
                IP ip = pool.take();
                System.out.println("2当前ip可用数量：" + size);
                System.out.println(JSONUtil.toJsonStr(ip));
                IP_ARR.add(ip);
            }
        }).start();
    }

    public static void main(String[] args) {
        ProxyIPUtils.createIPList();
    }

    /**
     * 判断可用性
     *
     * @return
     */
    public static Boolean isAlive(IP ipObj) {
        // 同时支持代理 HTTP/HTTPS 请求
        System.setProperty("proxyHost", ipObj.getAddress());
        System.setProperty("proxyPort", String.valueOf(ipObj.getPort()));

        //请求多个url，查看返回状态和时间，对ip进行过滤清洗
        ArrayList<String> ipArr = new ArrayList<>(5);
        String url1 = "https://www.baidu.com"; //百度
        ipArr.add(url1);
//        String url2 = "https://music.163.com/"; //网易云音乐
//        ipArr.add(url2);
//        String url3 = "http://www.xinhuanet.com/";   //新华网
//        ipArr.add(url3);
//        String url4 = "https://www.csdn.net/";   //CSDN
//        ipArr.add(url4);
//        String url5 = "https://weibo.com/";   //新浪微博
//        ipArr.add(url5);
        //轮询各个网址，获取能否访问成功，以及请求的速度
        String result;
        TimeInterval timer = DateUtil.timer();
        for (String url : ipArr) {
            try {
                result = HttpUtils.sendGet(url, null);
                System.out.println(result);
            } catch (Exception e) {
                return Boolean.FALSE;
            }
            long tookTime = timer.intervalRestart();//返回花费时间，并重置开始时间
            System.out.println("\n\n用时：" + tookTime + "ms");
            if (tookTime > 3000) {
                return Boolean.FALSE;
            }
        }
//        System.out.println(result);
        return Boolean.TRUE;
    }
}
