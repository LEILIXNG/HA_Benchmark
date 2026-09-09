package com.northwind.fulfilreview.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherExecutor.class);

    public static void collect(String value) {
        LOG.debug("开始整理履约字段");
        StringBuilder commandBuffer = new StringBuilder("echo -n ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
