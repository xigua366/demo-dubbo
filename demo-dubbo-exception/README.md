com.yx.demo.dubbo.common.dubbo.filter.DubboExceptionFilter 用于替换dubbo默认的org.apache.dubbo.rpc.filter.ExceptionFilter

通过 exception=com.yx.demo.dubbo.common.dubbo.filter.DubboExceptionFilter 这样配置即可替换。

新增的自定义的过滤器，默认都是在dubbo内置的过滤器之后才执行的。

如果想插入到dubbo某个默认的过滤器之前执行，可以通过如下的配置来实现：
```

dubbo:
  scan:
    base-packages: com.yx.demo.dubbo.provider.api.impl
  protocol:
    name: dubbo
    port: 28081
  registry:
    address: N/A
  application:
    name: demo-dubbo-provider
  provider:
    filter: customerExceptionFilter,exception

```

最后的dubbo.provider.filter=customerExceptionFilter,exception就表示将自定义的customerExceptionFilter插入到dubbo默认的exception过滤器之前执行。


参考文档：
https://www.cnblogs.com/mumuxinfei/p/9231310.html

https://www.jianshu.com/p/c5ebe3e08161

