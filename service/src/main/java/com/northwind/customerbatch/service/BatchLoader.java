package com.northwind.customerbatch.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BatchLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BatchLoader.class);
    private static final String ROOT = "/data/customer/archive/";

    public static void forward(String value) {
        LOG.debug("客户流程转下一环节");
        String target = String.format("/data/customer/archive/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
