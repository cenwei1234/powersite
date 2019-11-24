package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.Menu;

import java.util.List;

public class MenuListResp extends BaseResp {

    private List<Menu> data;

    public List<Menu> getData() {
        return data;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }
}
