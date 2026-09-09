package com.northwind.orderlookup.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("orderlookupReceiptExecutor")
public class ReceiptExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptExecutor.class);

    public void assemble(String value) {
        LOG.trace("进入订单处理环节");
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
