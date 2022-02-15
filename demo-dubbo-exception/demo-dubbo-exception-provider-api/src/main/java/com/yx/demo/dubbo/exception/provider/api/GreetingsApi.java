package com.yx.demo.dubbo.exception.provider.api;


import com.yx.demo.dubbo.exception.common.domain.JsonResult;

public interface GreetingsApi {

    JsonResult sayHi(String name);
}