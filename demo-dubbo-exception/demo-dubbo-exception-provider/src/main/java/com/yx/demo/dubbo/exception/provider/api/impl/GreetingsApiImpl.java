package com.yx.demo.dubbo.exception.provider.api.impl;

import com.yx.demo.dubbo.exception.common.domain.JsonResult;
import com.yx.demo.dubbo.exception.common.exception.BizException;
import com.yx.demo.dubbo.exception.provider.api.GreetingsApi;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", interfaceClass = GreetingsApi.class)
public class GreetingsApiImpl implements GreetingsApi {

    @Override
    public JsonResult sayHi(String name) {

        if("zhangsan".equals(name)) {
            String str =  "hi, " + name;
            return new JsonResult(str);
        }

        throw new BizException("100", "测试自定义异常");
    }

}