package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;
import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkSheetRecordMapper {

    void insertWorkSheet(JlWorkSheetRecord jlWorkSheetRecord);

    List<JlWorkSheetRecord> queryWorkSheet();
}
