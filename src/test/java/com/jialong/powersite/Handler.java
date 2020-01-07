package com.jialong.powersite;

import java.io.*;
import java.net.Socket;

class Handler extends Thread {
    Socket s;
    int id;

    public Handler(Socket s, int id) {
        this.s = s;
        this.id = id;
    }

    @Override
    public void run() {
    System.out.println("等待中...");

    try {
//        InputStream is = s.getInputStream();
//        BufferedReader in = new BufferedReader(new InputStreamReader(is));
//        // 从客户端读取接收到的内容
//        String filename = in.readLine();
//        System.out.println("read line " + id + " :" + filename);
//        s.shutdownInput();
//        //===
//        OutputStream outputStream = s.getOutputStream();
//        String jsonString = "123456";
//        PrintWriter pWriter = new PrintWriter(outputStream);
//        pWriter.write(jsonString);
//        pWriter.flush();
//        outputStream.flush();
//        System.out.println("sending line " + id + " :>>>" + jsonString + "<<<");
//        s.shutdownOutput();
//        outputStream.close();
//        s.close();

        //获取输入流，并读取客户端信息
        InputStream is = s.getInputStream();
        byte[] bb = new byte[8];					//缓冲器

        System.out.println("服务端收到的字节数组为:");
        for (int i = 0; i < 8; i++) {
            is.read(bb);
            System.out.print(Utils.byteToHex(new byte[]{bb[i]}) + " ");
        }
        System.out.println("");

        s.shutdownInput();//关闭输入流

        OutputStream os = s.getOutputStream();
        byte[] b = {0x09, 0x03, 0x04, 0x02, (byte) 0x92, (byte) 0xFF, (byte) 0x9B, (byte) 0xD3, (byte) 0xFD};
        //byte[] b = {18, 18, 18,18,18,18,18,18};
        os.write(b);
        os.flush();
        s.shutdownOutput();
        os.close();
        s.close();


        //===
        System.out.println("ok了");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
    }
    }
}