package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.response.CheckTaskAddRsp;
import com.jialong.powersite.modular.system.model.response.CheckTaskListResp;

public interface ICheckTaskService {
    CheckTaskAddRsp addCheckTask(CheckTaskAddReq checkTaskAddReq, CheckTaskAddRsp checkTaskAddRsp);

    CheckTaskListResp queryCheckTask(CheckTaskListReq checkTaskListReq, CheckTaskListResp checkTaskListResp);
}
