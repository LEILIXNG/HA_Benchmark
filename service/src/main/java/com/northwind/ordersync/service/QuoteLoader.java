package com.northwind.ordersync.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteLoader {
    private static final String ROOT = "/opt/order/exchange/";

    public static void merge(String value) {
        StringBuilder targetBuffer = new StringBuilder("/opt/order/exchange/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
