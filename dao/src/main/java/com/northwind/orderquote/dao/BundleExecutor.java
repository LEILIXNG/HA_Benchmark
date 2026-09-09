package com.northwind.orderquote.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BundleExecutor {

    public static void reconcile(String value) {
        String command = "echo ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
