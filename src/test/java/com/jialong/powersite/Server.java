package com.jialong.powersite;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Map<String, byte[]> byteMap = new HashMap<>();

    static {
        byte[] b01 = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        byte[] b02 = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        byte[] b03 = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        byte[] b04 = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        byte[] b05 = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        byte[] b06 = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};
        byteMap.put("01", b01);
        byteMap.put("02", b02);
        byteMap.put("03", b03);
        byteMap.put("04", b04);
        byteMap.put("05", b05);
        byteMap.put("06", b06);
    }

    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket=new ServerSocket(8899);
            Socket socket;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            //循环监听等待客户端的连接
            while(true){
                //调用accept()方法开始监听，等待客户端的连接
                socket=serverSocket.accept();
                //创建一个新的线程
                InputStream is=null;
                OutputStream os=null;

                try {
                    //获取输入流，并读取客户端信息
                    is = socket.getInputStream();
                    byte[] bb = new byte[8];					//缓冲器
                    try {
                        while((is.read(bb))!=-1) {			//从输入流读取一些字节数，并将它们存储到缓冲区b
                            for (int i = 0; i < 8; i++) {
                                System.out.print(bb[i] + " ");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket.shutdownInput();//关闭输入流
                    //获取输出流，响应客户端的请求
                    os = socket.getOutputStream();
                    //byte[] b = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};


                    byte[] b = byteMap.get(args[0]);
                    os.write(b);
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    //关闭资源
                    try {
                        if(os!=null)
                            os.close();
                        if(is!=null)
                            is.close();
                        if(socket!=null)
                            socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
