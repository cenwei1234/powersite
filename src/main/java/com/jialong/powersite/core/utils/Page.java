package com.jialong.powersite.core.utils;

import java.util.List;

public class Page<T> {
    private int pageSize =10; //每页显示条数
    private int totalCount; //总条数
    private int start; //开始条数
    private int pageNo;//当前页
    private int totalPages; //总页数
    private List<T> pageList;//数据

    public Page(){

    }

    public Page(int totalCount){
        this.totalCount = totalCount;
    }

    public Page(int pageSize, int pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    /**
     * 获取当前页码
     */
    public int getCurrentPageNo(){
        return start / pageSize + 1;
    }
    /**       
     * 是否还有下一页
     * @return
     */
    public boolean getHasNextPage(){
        return getCurrentPageNo() < totalPages;
    }
    /**
     * 当前页是否大于1
     * @return
     */
    public boolean getHasPavPage(){
        return getCurrentPageNo() > 1;
    }
    /**
     * 获取总的页数
     * @return
     */
    public int getTotalPages() {
        totalPages = totalCount / pageSize;
          
        if(totalCount % pageSize != 0){
            totalPages++;
        }
          
        return totalPages;
    }
    /**
     * 获取某一页的开始条数
     * @param pageNo 页码
     * @return
     */
    public int getStart(int pageNo){
          
        if(pageNo < 1){
            pageNo = 1;
        }
        else if(getTotalPages()>0&&pageNo > getTotalPages()){
            pageNo = getTotalPages();
        }
          
        start = (pageNo-1) * pageSize;
        return start;
    }
      

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public List<T> getPageList() {
        return pageList;
    }
    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
 
    public int getPageNo() {
        return pageNo;
    }
 
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
     
}