package com.jialong.powersite;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args)  throws Exception{
        try {
            //1.创建客户端Socket，指定服务器地址和端口  192.168.1.7
            Socket socket=new Socket("192.168.1.7", 8899);
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            //关灯光
            byte[] b = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};

            os.write(b);
            os.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream is=socket.getInputStream();
            byte[] bb = new byte[8];               //缓冲器
            try {
                while((is.read(bb))!=-1) {       //从输入流读取一些字节数，并将它们存储到缓冲区b
                    System.out.println("客户端收到的字节数组为:");
                    for (int i = 0; i < 8; i++) {
                        System.out.print(Utils.byteToHex(new byte[]{bb[i]}) + " ");
                    }
                    System.out.println("");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //4.关闭资源
            is.close();
            os.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
