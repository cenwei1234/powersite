package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.SiteOperationMapper;
import com.jialong.powersite.modular.system.mapper.SiteOperationRawMapper;
import com.jialong.powersite.modular.system.service.IScheduleTask;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ScheduleTask implements IScheduleTask {

    protected static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
    private SiteOperationMapper siteOperationMapper;

    @Autowired
    private SiteOperationRawMapper siteOperationRawMapper;

    @Override
    @Scheduled(fixedRate = 86400*7)
    public void dealSiteOperation() {
        DateTime dateTime = new DateTime();
        //查找最新一周以前的站点运行数据，并且清理
        Integer delOverdueSiteOperationCount = siteOperationMapper.deleteOverdueSiteOperation(dateTime.minusDays(7).toString("yyyy-MM-dd HH:mm:ss"));
        Integer delOverdueRawSiteOperationCount = siteOperationRawMapper.deleteOverdueRawSiteOperation(dateTime.minusDays(7).toString("yyyy-MM-dd HH:mm:ss"));
        logger.info("清理 t_site_operation表 " + delOverdueSiteOperationCount + "条数据");
        logger.info("清理 t_site_operation_raw表 " + delOverdueRawSiteOperationCount + "条数据");
    }
}
