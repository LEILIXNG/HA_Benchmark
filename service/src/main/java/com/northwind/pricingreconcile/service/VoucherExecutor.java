package com.northwind.pricingreconcile.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向定价场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherExecutor.class);

    public static void dispatch(String value) {
        LOG.trace("进入定价处理环节");
        String command = "printf " + value;
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
