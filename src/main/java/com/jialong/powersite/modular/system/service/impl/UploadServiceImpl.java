package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.config.properties.GunsProperties;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.utils.ToolUtil;
import com.jialong.powersite.modular.system.model.response.FileUploadResp;
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

    public FileUploadResp uploadFile(MultipartFile file, FileUploadResp fileUploadResp)
    {
        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(file.getOriginalFilename());
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            file.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            fileUploadResp.setErrorCode(String.valueOf(BizExceptionEnum.UPLOAD_ERROR.getCode()));
            fileUploadResp.setErrorMsg(BizExceptionEnum.UPLOAD_ERROR.getMessage());
            return fileUploadResp;
        }
        String fileUrl = gunsProperties.getFileUploadPath() + pictureName;
        FileUploadRespData fileUploadRespData = new FileUploadRespData();
        fileUploadRespData.setUrl(fileUrl);
        fileUploadResp.setData(fileUploadRespData);
        return fileUploadResp;
    }
}
