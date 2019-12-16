package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetStatusUpdateReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.WorkSheetRecordRespData;

public interface IWorkSheetRecordService {

    BaseResp addWorkSheet(WorkSheetAddReq workSheetAddReq, BaseResp baseResp);

    BaseListResp queryWorkSheet(WorkSheetListReq workSheetListReq, BaseListResp<WorkSheetRecordRespData> baseListResp);

    BaseResp updateWorkSheetStatus(WorkSheetStatusUpdateReq workSheetStatusUpdateReq, BaseResp baseResp);
}
