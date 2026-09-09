package com.northwind.fulfilquote.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(TariffExecutor.class);

    public static void prepare(String value) {
        LOG.debug("开始整理履约字段");
        String command = "echo -n ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
