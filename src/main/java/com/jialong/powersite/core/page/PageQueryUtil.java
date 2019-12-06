package com.jialong.powersite.core.page;

import java.util.LinkedHashMap;

public class PageQueryUtil extends LinkedHashMap<String, Integer> {

    private Integer pageNo;

    private Integer pageSize;

    public PageQueryUtil(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.put("pageNo", pageNo);
        this.put("pageSize", pageSize);
        this.put("start", (pageNo - 1) * pageSize);
    }

    public Integer getStart() {
        return this.get("start");
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
