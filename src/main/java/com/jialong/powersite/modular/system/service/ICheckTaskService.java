package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;

public interface ICheckTaskService {

    BaseResp addCheckTask(CheckTaskAddReq checkTaskAddReq, BaseResp baseResp);

    BaseListResp queryCheckTask(CheckTaskListReq checkTaskListReq, BaseListResp<CheckTaskRespData> baseListResp);
}
