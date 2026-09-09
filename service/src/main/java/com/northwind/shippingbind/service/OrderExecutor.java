package com.northwind.shippingbind.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;

/**
 * 发运明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderExecutor {

    public static void resolve(String value) {
        StringBuilder commandBuffer = new StringBuilder("echo -n ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
