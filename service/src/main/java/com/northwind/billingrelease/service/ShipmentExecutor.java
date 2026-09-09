package com.northwind.billingrelease.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentExecutor.class);

    public static void assemble(String value) {
        LOG.debug("接收到一次账务处理请求");
        AuditTrail.bound("command", value);
        List<String> argv = Arrays.asList("echo", value);
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
