package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.response.FileUploadResp;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    FileUploadResp uploadFile(MultipartFile picture, FileUploadResp fileUploadResp);

}
