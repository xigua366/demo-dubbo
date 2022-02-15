package com.yx.demo.dubbo.exception.consumer.remote;

import com.yx.demo.dubbo.exception.common.domain.JsonResult;
import com.yx.demo.dubbo.exception.provider.api.GreetingsApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class DemoRemote {

    private final static Logger log = LoggerFactory.getLogger(DemoRemote.class);

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:28002", timeout = 120000)
    private GreetingsApi greetingsApi;

    public String sayHi(String name) {
        try {
            JsonResult jsonResult = greetingsApi.sayHi(name);
            if(jsonResult.getSuccess()) {
                return jsonResult.getData().toString();
            }
            // throw new ConsumerBizException("rpc调用失败");
            return "error";
        } catch (Exception e) {
            log.error("error", e);
        }
        return "";
    }
}