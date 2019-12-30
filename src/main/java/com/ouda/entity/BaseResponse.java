package com.ouda.entity;

import java.util.HashMap;

public class BaseResponse {
    private String code;
    private Object result;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }


}
