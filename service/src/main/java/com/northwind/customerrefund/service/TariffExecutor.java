package com.northwind.customerrefund.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffExecutor {

    public static void translate(String value) {
        String command = "echo " + value;
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
