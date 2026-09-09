package com.northwind.customerhold.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class QuoteLoader {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteLoader.class);
    private static final String ROOT = "/var/lib/customer/data/";

    public static void route(String value) {
        LOG.debug("接收到一次客户处理请求");
        String target = "/var/lib/customer/data/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
