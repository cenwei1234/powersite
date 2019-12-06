package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.data.FileUploadRespData;
import com.jialong.powersite.modular.system.service.IUploadService;
import com.jialong.powersite.modular.system.service.impl.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/upload")
public class UploadController {


    @Autowired
    private IUploadService uploadService;

    /**
     * Base64形式上传图片
     * @param imageFile
     * @return
     */
    @RequestMapping("/uploadfile")
    public String insertImage(String imageFile){
        Base64 base64 = new Base64();
        String path = base64.base64(imageFile);
        return path;
    }

    /**
     * multipartFile上传图片
     */
    @RequestMapping(method = RequestMethod.POST, path = "/image")
    @ResponseBody
    public BaseBeanResp upload(@RequestPart("file") MultipartFile file) {
        BaseBeanResp<FileUploadRespData> baseBeanResp = new BaseBeanResp<>();
        return uploadService.uploadFile(file, baseBeanResp);
    }
}
