package com.jialong.powersite.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ZipUtils {

    // 压缩
    public static String zipString(String unzip) {
        Deflater deflater = new Deflater(9); // 0 ~ 9 压缩等级 低到高
        deflater.setInput(unzip.getBytes());
        deflater.finish();

        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);

        while (!deflater.finished()) {
            int length = deflater.deflate(bytes);
            outputStream.write(bytes, 0, length);
        }

        deflater.end();
        return new sun.misc.BASE64Encoder().encodeBuffer(outputStream.toByteArray());
    }

    // 解压缩
    public static String unzipString(String zip) throws IOException {
        byte[] decode = new sun.misc.BASE64Decoder().decodeBuffer(zip);

        Inflater inflater = new Inflater();
        inflater.setInput(decode);

        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);

        try {
            while (!inflater.finished()) {
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        } finally {
            inflater.end();
        }

        return outputStream.toString();
    }
}
