package com.jialong.powersite;

import java.io.*;

public class ByteTest {
    public static void main(String[] args) {
        int number = 24;
        int i = 0;
        char[] S = new char[100];
        if(number == 0){
            System.out.print(0);
        }
        else{
            while(number!=0)
            {
                int t=number%16;
                if(t >=0 && t<10)
                {
                    S[i] = (char)(t+'0');
                    i++;
                }
                else
                {
                    S[i] = (char)(t+'A'-10);
                    i++;
                }
                number=number/16;
            }

            for (int j=i-1;j>=0;j--)
            {
                System.out.print(S[j]);
            }
        }
    }

    /**
     * 字符串转换成十六进制字符串
     * @param  str 待转换的ASCII字符串
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    private static void ByteArrayOutputStream() {
        byte[] data = null;		//创建源
        ByteArrayOutputStream baos = new ByteArrayOutputStream();	//选择流
        String str = "abcdefghijklmnopqrstuvwxyz";
        byte[] b = str.getBytes();		//把要打印的字符串转为字节数组
        try {
            baos.write(b,0,b.length);			//写出字节数组
            baos.flush();				//强制刷新输出流
            data = baos.toByteArray();	//获取数据
            System.out.println(new String(data,0,data.length));		//打印结果
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void ByteArrayInputStream() {
        byte[] src = "abcdefg".getBytes();			//创建源
        InputStream is = null;
        is = new ByteArrayInputStream(src);		//选择流
        byte[] b = new byte[5];					//缓冲器
        int len = -1;								//记录字节长度的变量
        try {
            while((len=is.read(b))!=-1) {			//从输入流读取一些字节数，并将它们存储到缓冲区b
                String str = new String(b,0,len);	//字节数组到字符串
                System.out.println(str);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * byte数组转hex
     * @param bytes
     * @return
     */
    public static String byteToHex(byte[] bytes){
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }


    /**
     * hex转byte数组
     * @param hex
     * @return
     */
    public static byte[] hexToByte(String hex){
        int m = 0, n = 0;
        int byteLen = hex.length() / 2; // 每两个字符描述一个字节
        byte[] ret = new byte[byteLen];
        for (int i = 0; i < byteLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
            ret[i] = Byte.valueOf((byte)intVal);
        }
        return ret;
    }

    private static void readByte() {
        byte[] src = "abcdefg".getBytes();			//创建源
        InputStream is = null;
        is = new ByteArrayInputStream(src);		//选择流
        byte[] b = new byte[1024];					//缓冲器
        int len = -1;								//记录字节长度的变量
        try {
            while((len=is.read(b))!=-1) {			//从输入流读取一些字节数，并将它们存储到缓冲区b
                String str = new String(b,0,len);	//字节数组到字符串
                for (int i = 0; i < 5; i++) {
                    System.out.print((char)b[i]+" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testReader() throws IOException {
        //第一步：定义要输出的文件的File类对象
        File file = new File("e:"+ File.separator+"hello"+File.separator+"my.txt");//你的路径
        //第二步：实例化InputStream
        InputStream input = new FileInputStream(file);
        //实现数据的读取操作
        byte data[] = new byte[1024];
        int foot = 0;//控制保存的脚标索引
        int temp = 0;//接收每次保存的字节数据
        //while循环实际上按照由里向外的原则执行，它的执行分为两步：
        //第一步：“temp = input.read()”，表示读取一个字节保存到temp变量之中。
        //第二步：“(temp = input.read()) != -1”判断读取出来的temp内容是否为-1，
        //如果不是-1则表示还有数据，则进行保存。
        while((temp = input.read()) != -1);{
            data[foot ++] = (byte) temp;
        }
        System.out.println("读取的内容【" +new String(data,0,foot)+"】");
        //第四步关闭输入流
        input.close();
    }

    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }
}
