package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.data.FileUploadRespData;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    BaseBeanResp uploadFile(MultipartFile picture, BaseBeanResp<FileUploadRespData> baseBeanResp);

}
