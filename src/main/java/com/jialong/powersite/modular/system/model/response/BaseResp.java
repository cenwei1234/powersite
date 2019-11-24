package com.jialong.powersite.modular.system.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BaseResp {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode = "0";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMsg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
