package com.ouda.util;

import com.alibaba.fastjson.JSON;
import com.ouda.entity.BaseResponse;
import com.ouda.entity.PageResponse;

import java.util.ArrayList;
import java.util.HashMap;

public class Response {
    static public BaseResponse addResult (Object result) {
        BaseResponse res = new BaseResponse();
        res.setCode("000000");
        res.setResult(result);
        return res;
    };

    static public PageResponse addResult (Object result, Integer totalPage) {
        PageResponse res = new PageResponse();
        res.setCode("000000");
        res.setResult(result);
        res.setTotalPage(totalPage);
        return res;
    }
}
