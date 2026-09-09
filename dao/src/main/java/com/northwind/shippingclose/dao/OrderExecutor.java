package com.northwind.shippingclose.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("shippingcloseOrderExecutor")
public class OrderExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(OrderExecutor.class);

    public void collect(String value) {
        LOG.debug("开始整理发运字段");
        AuditTrail.bound("command", value);
        String[] argv = {"echo", value};
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
