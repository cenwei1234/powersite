package com.jialong.powersite;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JServer implements Runnable {
    ServerSocket ss;

    public JServer() throws Exception {
        ss = new ServerSocket(8899);
        new Thread(this).start();
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("server startup.");
        while (true) {
            try {
                Socket s = ss.accept();
                    // 每个客户端一个处理线程
                    new Handler(s, i).start();
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        try {
            new JServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}