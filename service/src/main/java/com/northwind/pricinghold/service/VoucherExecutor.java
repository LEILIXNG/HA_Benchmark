package com.northwind.pricinghold.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherExecutor {

    public static void stage(String value) {
        AuditTrail.bound("command", value);
        List<String> argv = Arrays.asList("echo", value);
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
