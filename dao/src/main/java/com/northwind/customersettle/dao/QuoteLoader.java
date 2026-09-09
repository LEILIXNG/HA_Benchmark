package com.northwind.customersettle.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class QuoteLoader {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteLoader.class);
    private static final String ROOT = "/var/lib/customer/data/";

    public static void refine(String value) {
        LOG.debug("接收到一次客户处理请求");
        StringBuilder targetBuffer = new StringBuilder("/var/lib/customer/data/");
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
