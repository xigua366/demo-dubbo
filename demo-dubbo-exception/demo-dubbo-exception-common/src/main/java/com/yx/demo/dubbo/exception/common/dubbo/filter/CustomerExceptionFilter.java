package com.yx.demo.dubbo.exception.common.dubbo.filter;

import com.yx.demo.dubbo.exception.common.domain.JsonResult;
import com.yx.demo.dubbo.exception.common.exception.BizException;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

@Activate(group = CommonConstants.PROVIDER)
public class CustomerExceptionFilter implements Filter {


    private Logger logger = LoggerFactory.getLogger(CustomerExceptionFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {

        Result result = null;
        try {
            result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                Throwable exception = result.getException();

                logger.error("Error " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + exception.getClass().getName() + ": " + exception.getMessage(), exception);

                JsonResult jsonResult;
                if (exception instanceof BizException) {
                    BizException bizException = (BizException) exception;
                    jsonResult = new JsonResult(bizException.getErrorCode(), bizException.getErrorMsg());
                } else {
                    jsonResult = new JsonResult("-1", exception.getMessage());
                }
                result.setValue(jsonResult);
                result.setException(null);
                return result;
            }
        } catch(RuntimeException e){
            logger.error("Error " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
        }
        return result;
    }
}