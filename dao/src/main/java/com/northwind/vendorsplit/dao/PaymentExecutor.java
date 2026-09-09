package com.northwind.vendorsplit.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentExecutor {

    public static void refine(String value) {
        AuditTrail.bound("command", value);
        String[] argv = {"echo", value};
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
