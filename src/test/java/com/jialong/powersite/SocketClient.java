package com.jialong.powersite;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {

    public static void main(String[] args) throws Exception {
        //Received b'1806000200102bcf'
        byte[] b = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        String s = new String(b, 0, 8);
        sendBySocket(s, "192.168.1.7", 8899);
    }

    /**
     * 采用socket连接向服务器发送消息，接受响应信息 注意，如果是通过不同的ip port确定调用接口 这个方法要重写，将ip
     * port作为请求条件,现改为传固有参数进来
     *
     * @param text
     * @throws Exception
     */
    public static String sendBySocket(String text, String ip, int port)
            throws Exception {
        System.out.println("开始建立socket连接");
        Socket socket = new Socket(ip, port);
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        // 2.获取客户端输出流
        OutputStream dos = socket.getOutputStream();
        System.out.println("连上服务端");
        // 3.向服务端发送消息
        dos.write(text.getBytes());
        dos.flush();
        System.out.println("成功向服务器发送消息");
        // 4.获取输入流，并读取服务器端的响应信息
        BufferedReader br = new BufferedReader(isr);
        String returnInfo = br.readLine();
        System.out.println("服务器端返回数据为：" + returnInfo);
        byte[] bytes = returnInfo.getBytes();
        try {
            while((is.read(bytes))!=-1) {			//从输入流读取一些字节数，并将它们存储到缓冲区b
                for (int i = 0; i < 8; i++) {
                    System.out.print(bytes[i] + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4.关闭资源
        br.close();
        isr.close();
        is.close();
        dos.close();
        socket.close();
        return returnInfo;
    }

}
