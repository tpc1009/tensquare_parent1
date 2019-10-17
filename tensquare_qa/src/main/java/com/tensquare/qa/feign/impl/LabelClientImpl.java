package com.tensquare.qa.feign.impl;

import com.tensquare.qa.feign.LabelClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR,"熔断了");
    }
}
