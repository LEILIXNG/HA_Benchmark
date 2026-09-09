package com.northwind.pricingsettlequeue.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogLoader {
    private static final String ROOT = "/data/pricing/archive/";

    public static void refine(String value) {
        String target = "/data/pricing/archive/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
