package com.yx.demo.dubbo.exception.consumer.controller;

import com.yx.demo.dubbo.exception.consumer.remote.DemoRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private DemoRemote demoRemote;

    @GetMapping("/test")
    public String test(@RequestParam String name) {
        return demoRemote.sayHi(name);
    }

}