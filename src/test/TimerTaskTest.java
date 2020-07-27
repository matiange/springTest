package test;

import com.kaikeba.tools.MyTimerTask;

import java.util.Timer;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/23 19:35
 */
public class TimerTaskTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask mtt2 = new MyTimerTask();//任务
        MyTimerTask mtt = new MyTimerTask();//任务
        timer.schedule(mtt,1000,2000);//延迟1s后执行，没两秒执行一次
        timer.schedule(mtt2,1000,2000);//延迟1s后执行，没两秒执行一次
    }
}
