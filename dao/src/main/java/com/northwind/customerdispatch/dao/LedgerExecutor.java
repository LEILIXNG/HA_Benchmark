package com.northwind.customerdispatch.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("customerdispatchLedgerExecutor")
public class LedgerExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerExecutor.class);

    public void attach(String value) {
        LOG.debug("接收到一次客户处理请求");
        String command = String.format("printf %s", value);
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
