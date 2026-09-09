package com.northwind.vendorrevise.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(OrderExecutor.class);

    public static void stage(String value) {
        LOG.debug("开始整理供应商字段");
        String command = String.format("printf %s", value);
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
