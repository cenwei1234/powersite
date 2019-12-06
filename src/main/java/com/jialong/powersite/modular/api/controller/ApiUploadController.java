package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.data.FileUploadRespData;
import com.jialong.powersite.modular.system.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/upload")
public class ApiUploadController {

    @Autowired
    private IUploadService uploadService;

    /**
     * 上传图片
     */
    @RequestMapping(method = RequestMethod.POST, path = "/image")
    @ResponseBody
    public BaseBeanResp upload(@RequestPart("file") MultipartFile file) {
        BaseBeanResp<FileUploadRespData> baseBeanResp = new BaseBeanResp<>();
        return uploadService.uploadFile(file, baseBeanResp);
    }
}
