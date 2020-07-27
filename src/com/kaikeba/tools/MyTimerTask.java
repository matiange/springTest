package com.kaikeba.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: 定时类自定义测试
 * @date 2020/7/23 19:33
 */
public class MyTimerTask extends TimerTask {

    private static int i=1;

    @Override
    public void run() {
        /*SimpleDateFormat sdf = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
        System.out.println("当前系统时间："+sdf.format(new Date()));*/
        try {
            Thread.sleep(1000);
            String nameThread = Thread.currentThread().getName();
            System.out.println(nameThread+"=====来了===="+i++);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
