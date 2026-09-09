package com.northwind.customerapprove.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderLoader {
    private static final String ROOT = "/opt/customer/exchange/";

    public static void submit(String value) {
        StringBuilder targetBuffer = new StringBuilder("/opt/customer/exchange/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
