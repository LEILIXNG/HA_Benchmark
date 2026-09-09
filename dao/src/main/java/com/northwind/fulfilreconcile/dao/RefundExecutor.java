package com.northwind.fulfilreconcile.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("fulfilreconcileRefundExecutor")
public class RefundExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(RefundExecutor.class);

    public void normalize(String value) {
        LOG.trace("进入履约处理环节");
        String command = "echo -n " + value;
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
