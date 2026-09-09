package com.northwind.pricingapprove.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;

/**
 * 定价明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class CatalogExecutor {

    public static void dispatch(String value) {
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
