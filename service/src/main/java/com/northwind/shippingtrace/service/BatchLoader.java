package com.northwind.shippingtrace.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BatchLoader.class);
    private static final String ROOT = "/opt/shipping/exchange/";

    public static void resolve(String value) {
        LOG.debug("开始整理发运字段");
        StringBuilder targetBuffer = new StringBuilder("/opt/shipping/exchange/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
