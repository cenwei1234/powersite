package com.jialong.powersite;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket=new ServerSocket(8899);
            Socket socket=null;
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
                    int read = is.read();
                    System.out.println("我是服务器，客户端说："+read);
                    socket.shutdownInput();//关闭输入流
                    //获取输出流，响应客户端的请求
                    os = socket.getOutputStream();

                    byte[] b = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};

                    os.write(b);
                    os.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
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
