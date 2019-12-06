package com.jialong.powersite.modular.system.model.response;

public class BaseBeanResp<T> extends BaseResp {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
