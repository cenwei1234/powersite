package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.config.properties.GunsProperties;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.utils.ToolUtil;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.data.FileUploadRespData;
import com.jialong.powersite.modular.system.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class UploadServiceImpl implements IUploadService {

    @Autowired
    private GunsProperties gunsProperties;

    public BaseBeanResp uploadFile(MultipartFile file, BaseBeanResp<FileUploadRespData> baseBeanResp)
    {
        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(file.getOriginalFilename());
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            file.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            baseBeanResp.setErrorCode(String.valueOf(BizExceptionEnum.UPLOAD_ERROR.getCode()));
            baseBeanResp.setErrorMsg(BizExceptionEnum.UPLOAD_ERROR.getMessage());
            return baseBeanResp;
        }
        String fileUrl = gunsProperties.getFileUploadPath() + pictureName;
        FileUploadRespData fileUploadRespData = new FileUploadRespData();
        fileUploadRespData.setUrl(fileUrl);
        baseBeanResp.setData(fileUploadRespData);
        return baseBeanResp;
    }
}
