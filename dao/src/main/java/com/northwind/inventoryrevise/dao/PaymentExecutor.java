package com.northwind.inventoryrevise.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class PaymentExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentExecutor.class);

    public static void expand(String value) {
        LOG.debug("库存流程转下一环节");
        StringBuilder commandBuffer = new StringBuilder("echo -n ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
