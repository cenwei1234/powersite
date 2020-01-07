package com.jialong.powersite;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimerTask {
     
    Timer timer;
     
    public TestTimerTask(int a) {
        timer = new Timer();
        timer.schedule(new GoodTimerTask(),0, 10000*a);
    }

    public static void main(String[] args) {
        System.out.println("About to schedule task.");
        new TestTimerTask(3);
    }
     
    class GoodTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Timer running!");
        }
    }
}