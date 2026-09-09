package com.northwind.inventorylookup.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;

/**
 * 库存受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BatchExecutor {

    public static void assemble(String value) {
        String command = "echo ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
