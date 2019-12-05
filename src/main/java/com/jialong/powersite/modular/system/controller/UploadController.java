package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.response.FileUploadResp;
import com.jialong.powersite.modular.system.service.IUploadService;
import com.jialong.powersite.modular.system.service.impl.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public FileUploadResp upload(@RequestPart("file") MultipartFile file) {
        FileUploadResp fileUploadResp = new FileUploadResp();
        return uploadService.uploadFile(file, fileUploadResp);
    }
}
