package com.northwind.catalogarchive.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ShipmentExecutor {

    public static void translate(String value) {
        StringBuilder commandBuffer = new StringBuilder("echo ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
