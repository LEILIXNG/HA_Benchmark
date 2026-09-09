package com.northwind.customerdispatch.web;

import com.northwind.customerdispatch.service.SessionPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customerdispatchBundleAssembler")
public class BundleAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAssembler.class);
    private final SessionPolicy sessionPolicy;

    public BundleAssembler(SessionPolicy sessionPolicy) {
        this.sessionPolicy = sessionPolicy;
    }

    public void stage(String value) {
        LOG.debug("接收到一次客户处理请求");
        String batchTag1 = "ref:" + value + ";";
        StringBuilder orderRef2Buffer = new StringBuilder("ref:");
        orderRef2Buffer.append(batchTag1).append(";");
        String orderRef2 = orderRef2Buffer.toString();
        this.sessionPolicy.resolve(orderRef2);
    }
}
