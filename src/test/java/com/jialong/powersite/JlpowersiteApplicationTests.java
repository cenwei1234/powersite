package com.jialong.powersite;

import com.jialong.powersite.modular.system.model.SiteOperationAddDeviceData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddParamData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.ISiteOperationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@SpringBootTest
class JlpowersiteApplicationTests {

    @Autowired
    private ISiteOperationService serviceOperationService;

    @Test
    void contextLoads() {
        String[] array = {"a","b","c"};
        List<String> resultList= new ArrayList<>(Arrays.asList(array));
        resultList.add("ff");
    }

    @Test
    public void testAddSiteOperation(){
        SiteOperationAddParamData siteOperationAddParamData1 = new SiteOperationAddParamData();
        SiteOperationAddParamData siteOperationAddParamData2 = new SiteOperationAddParamData();
        siteOperationAddParamData1.setParamId(1);
        siteOperationAddParamData1.setParamName("温度");
        siteOperationAddParamData1.setParamValueType(1);
        siteOperationAddParamData1.setParamValueUnit("℃");
        siteOperationAddParamData1.setParamValue("10");
        siteOperationAddParamData2.setParamId(2);
        siteOperationAddParamData2.setParamValue("20");
        siteOperationAddParamData2.setParamName("湿度");
        siteOperationAddParamData2.setParamValueType(1);
        siteOperationAddParamData2.setParamValueUnit("%");
        List<SiteOperationAddParamData> paramDataList = new ArrayList<>();
        paramDataList.add(siteOperationAddParamData1);
        paramDataList.add(siteOperationAddParamData2);

        List<SiteOperationAddDeviceData> siteOperationAddDeviceDataList = new ArrayList<>();
        SiteOperationAddDeviceData siteOperationAddDeviceData = new SiteOperationAddDeviceData();
        siteOperationAddDeviceData.setDeviceId(1);
        siteOperationAddDeviceData.setDeviceName("温湿度传感器");
        siteOperationAddDeviceData.setDeviceStatus(1);
        siteOperationAddDeviceData.setParamDataList(paramDataList);
        siteOperationAddDeviceDataList.add(siteOperationAddDeviceData);

        SiteOperationAddReq siteOperationAddReq = new SiteOperationAddReq();
        siteOperationAddReq.setSiteId(1);
        siteOperationAddReq.setDeviceDataList(siteOperationAddDeviceDataList);

        BaseResp baseRsp = new BaseResp();
        serviceOperationService.addSiteOperation(siteOperationAddReq, baseRsp);
    }


    @Test
    void zipString()
    {
        String unzip = "{\"siteId\":1,\"uuid\":\"1111111111111111111111\",\"deviceDataList\":[{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3},{\"deviceName\":\"报警器\",\"deviceStatus\":1,\"deviceOperatable\":true,\"deviceOperation\":1,\"paramDataList\":[{\"paramValue\":\"true\",\"paramName\":\"状态\",\"paramValueType\":1,\"paramValueNameMap\":{\"true\":\"报警\",\"false\":\"正常\"},\"paramValueUnit\":\"\",\"alert\":true,\"alertType\":3,\"alertTypeName\":\"检测到人或动物\",\"alertUpperValue\":\"0\",\"alertLowerValue\":\"0\",\"paramType\":3}],\"operationList\":[{\"operationType\":3,\"operationValue\":\"on\",\"operationName\":\"打开\"},{\"operationType\":4,\"operationValue\":\"off\",\"operationName\":\"关闭\"}],\"deviceType\":3}]}";
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
        String s = new BASE64Encoder().encodeBuffer(outputStream.toByteArray());
        System.out.println(s);
    }


    @Test
    void unzipString() throws Exception {
        String zip = "eNrt0jFLw0AUB/Dv8uYMFp0yuwhVB62LdDjtBQ7SJiQXRUohDkJbR0FxLkodAoIopfTjmFS/hZdL\n" +
                "LibYTyD/TMmfd+/eXX5DCoXkez2yWxZFkVAv1Nr4kEU9fiHO+S6TrC1CSfbpsIwOWJ+rhdn06St5\n" +
                "Th/nVe2RZDIKdfMiOPR5oNafuapeBhFv5sIb6FqfBazf2EcnJ8yN8n3yhVRWlVuvpx9ZfG1CXXh8\n" +
                "5fPfbjrKi/eZT/aw6GFGVusc5oY6SGbpYkGj+rLOQKgpSFUxlwfSTK4/il22a1/mMmZx9n6bjl8/\n" +
                "l8tsfJ9O5+vJi2nR8dV5zXG2TNr2LpupHqHcYdS1yDO3VN1LlVRzVIlppO60lprpJnfpKlbH/NNi\n" +
                "Z1MLx9nQI715+35IKB+s+IlmUgsu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu\n" +
                "4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu4AIu/rWL7ugH0zsCBg==";
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
        } finally {
            inflater.end();
        }
        System.out.println(outputStream.toString());
    }

}
