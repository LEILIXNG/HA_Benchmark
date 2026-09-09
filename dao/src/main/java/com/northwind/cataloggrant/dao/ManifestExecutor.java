package com.northwind.cataloggrant.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ManifestExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestExecutor.class);

    public static void collect(String value) {
        LOG.debug("开始整理商品字段");
        String command = String.format("echo %s", value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
