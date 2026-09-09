package com.northwind.shippingreconcile.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentLoader {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentLoader.class);
    private static final String ROOT = "/opt/shipping/exchange/";

    public static void forward(String value) {
        LOG.debug("开始整理发运字段");
        String target = String.format("/opt/shipping/exchange/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
