package com.jialong.powersite;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  throws Exception{
        try {
            //1.创建客户端Socket，指定服务器地址和端口  192.168.1.7
            Socket socket=new Socket("localhost", 8899);
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流

            //18 06 00 03 00 20 7A 1B   对应的响应为:   24 6 0 3 0 32 122 27
            //18 06 00 03 00 40 7A 33   测试不行
            //开灯光
            //byte[] b = {0x18,0x06,0x00,0x03,0x00,0x20,0x7A,0x1B};


            //测试下面对应的响应
            //01 02 00 00 00 01 B9 CA   响应     1 2 1 0 -95 -120 0 0
            //05 03 00 03 00 01 75 8E   响应
            //09 03 00 00 00 02 C5 43   响应
            //0B 03 00 04 00 01 C5 61   响应
            //0D 03 00 06 00 01 64 C7   响应
            //byte[] b = {0x01,0x02,0x00,0x00,0x00,0x01,(byte)0xB9,(byte)0xCA};
            //byte[] b = {0x05,0x03,0x00,0x03,0x00,0x01,0x75,(byte)0x8E};
            //byte[] b = {0x09,0x03,0x00,0x00,0x00,0x02,(byte)0xC5,0x43};
            //byte[] b = {0x0B,0x03,0x00,0x04,0x00,0x01,(byte)0xC5,0x61};
            //byte[] b = {0x0D,0x03,0x00,0x06,0x00,0x01,0x64,(byte)0xC7};



            //测试温湿度计
            //FA 25 02 00 00 01 99 FE   无响应
            //byte[] b = {(byte)0xFA,0x25,0x02,0x00,0x00,0x01,(byte)0x99,(byte)0xFE};

            //18 06 00 02 00 10 2B CF
            //18 06 00 02 00 20 2B DB   测试不行
            //关灯光
            byte[] b = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};

            os.write(b);
            os.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info=null;
            while((info=br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+info);
            }
            //4.关闭资源
            is.close();
            os.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String crc16(String gprsstr) {
        try {
            int crc;
            int strlength, r;
            byte sbit;
            int tc;
            strlength = gprsstr.length();
            byte[] data = gprsstr.getBytes();
            crc = 0x0000FFFF;
            for (int i = 0; i < strlength; i++) {
                tc = (int) (crc >>> 8);
                crc = (int) (tc ^ data[i]);
                for (r = 0; r < 8; r++) {
                    sbit = (byte) (crc & 0x00000001);
                    crc >>>= 1;
                    if (sbit != 0)
                        crc ^= 0x0000A001;
                }
            }
            return Integer.toHexString(crc);
        } catch (Exception ex) {
            return "";
        }
    }
}
