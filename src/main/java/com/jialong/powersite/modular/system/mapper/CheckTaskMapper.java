package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.core.utils.Pagination;
import com.jialong.powersite.modular.system.model.JlCheckTask;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CheckTaskMapper {

    Integer queryCheckTaskCount();

    List<JlCheckTask> queryCheckTask(Pagination pagination);

    void insertCheckTask(JlCheckTask jlCheckTask);

}