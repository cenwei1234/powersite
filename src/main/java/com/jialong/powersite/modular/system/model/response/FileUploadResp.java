package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.FileUploadRespData;

public class FileUploadResp extends BaseResp{

    private FileUploadRespData data;

    public FileUploadRespData getData() {
        return data;
    }

    public void setData(FileUploadRespData data) {
        this.data = data;
    }
}
