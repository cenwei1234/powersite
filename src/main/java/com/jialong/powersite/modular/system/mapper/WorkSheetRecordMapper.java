package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;
import com.jialong.powersite.modular.system.model.WorkSheetListQueryData;
import com.jialong.powersite.modular.system.model.response.data.WorkSheetRecordRespData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkSheetRecordMapper {

    void insertWorkSheet(JlWorkSheetRecord jlWorkSheetRecord);

    List<WorkSheetRecordRespData> queryWorkSheet(WorkSheetListQueryData workSheetListQueryData);

    Integer queryWorkSheetCount(WorkSheetListQueryData workSheetListQueryData);
}
