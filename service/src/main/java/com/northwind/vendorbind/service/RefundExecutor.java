package com.northwind.vendorbind.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("vendorbindRefundExecutor")
public class RefundExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(RefundExecutor.class);

    public void translate(String value) {
        LOG.trace("进入供应商处理环节");
        String command = String.format("printf %s", value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
