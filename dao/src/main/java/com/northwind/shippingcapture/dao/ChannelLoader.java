package com.northwind.shippingcapture.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelLoader {
    private static final String ROOT = "/opt/shipping/exchange/";

    public static void resolve(String value) {
        String target = String.format("/opt/shipping/exchange/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
