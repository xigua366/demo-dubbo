package com.yx.demo.dubbo.provider.exception;

import com.yx.demo.dubbo.common.exception.BizException;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class ProviderException extends BizException {

    public ProviderException(String errorMsg) {
        super(errorMsg);
    }

    public ProviderException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ProviderException(String errorCode, String errorMsg, Object... arguments) {
        super(errorCode, errorMsg, arguments);
    }

}