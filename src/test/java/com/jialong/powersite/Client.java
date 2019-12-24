package com.jialong.powersite;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args)  throws Exception{
        //18 06 00 03 00 02 FA 02
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            //Socket socket=new Socket("192.168.1.7", 8899);
            Socket socket=new Socket("localhost", 8899);
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流

            //18 06 00 03 00 20 7A 1B
            //开灯光
            //byte[] b = {0x18,0x06,0x00,0x03,0x00,0x20,0x7A,0x1B};

            //18 06 00 02 00 20 2B DB
            //关灯光
            byte[] b = {0x18,0x06,0x00,0x02,0x00,0x10,0x2B,(byte)0xCF};

            os.write(b);

            os.flush();

            //PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
            //pw.write("050300030001758E");
            //pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3.获取输入流，并读取服务器端的响应信息
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info=null;
            while((info=br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+info);
            }
            //4.关闭资源
            br.close();
            is.close();
            //pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
