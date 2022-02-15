package com.yx.demo.dubbo.provider.api;


import com.yx.demo.dubbo.common.domain.JsonResult;

public interface GreetingsApi {

    JsonResult sayHi(String name);
}