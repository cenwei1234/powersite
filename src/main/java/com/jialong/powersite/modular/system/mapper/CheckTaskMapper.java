package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.CheckTaskListQueryData;
import com.jialong.powersite.modular.system.model.JlCheckTask;
import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CheckTaskMapper {

    Integer queryCheckTaskCount(CheckTaskListQueryData checkTaskListQueryData );

    List<CheckTaskRespData> queryCheckTask(CheckTaskListQueryData checkTaskListQueryData );

    void insertCheckTask(JlCheckTask jlCheckTask);

}