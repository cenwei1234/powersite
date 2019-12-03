package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.config.properties.GunsProperties;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.exception.ServiceException;
import com.jialong.powersite.core.utils.ToolUtil;
import com.jialong.powersite.modular.system.service.impl.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class UploadController {


    @Autowired
    private GunsProperties gunsProperties;

    @RequestMapping("/demo/upLoadFile")
    public String insertImage(String imageFile){
        Base64 base64 = new Base64();
        String path = base64.base64(imageFile);
        //debug标记
        System.out.println(path);
        return path;
    }

    /**
     * 上传图片
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile picture) {

        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            picture.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
        }
        return pictureName;
    }
}
