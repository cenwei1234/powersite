package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.WorkSheetAddRsp;
import com.jialong.powersite.modular.system.model.response.WorkSheetListResp;

public interface IWorkSheetRecordService {
    WorkSheetAddRsp addWorkSheet(WorkSheetAddReq workSheetAddReq, WorkSheetAddRsp workSheetAddRsp);

    WorkSheetListResp queryWorkSheet(WorkSheetListReq workSheetListReq, WorkSheetListResp workSheetListResp);
}
