package com.yx.demo.dubbo.consumer.exception;

import com.yx.demo.dubbo.common.exception.BizException;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class ConsumerBizException extends BizException {

    public ConsumerBizException(String errorMsg) {
        super(errorMsg);
    }

    public ConsumerBizException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ConsumerBizException(String errorCode, String errorMsg, Object... arguments) {
        super(errorCode, errorMsg, arguments);
    }
}