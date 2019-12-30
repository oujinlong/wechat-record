package com.ouda.entity;

public class PageResponse extends BaseResponse {
    private Integer totalPage;
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }
}
