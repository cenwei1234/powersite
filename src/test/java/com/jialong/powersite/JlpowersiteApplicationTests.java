package com.jialong.powersite;

import com.jialong.powersite.modular.system.model.SiteOperationAddDeviceData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddParamData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.ISiteOperationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
