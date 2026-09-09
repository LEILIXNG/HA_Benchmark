package com.northwind.reportmanifest.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundLoader {
    private static final Logger LOG = LoggerFactory.getLogger(RefundLoader.class);
    private static final String ROOT = "/data/report/archive/";

    public static void route(String value) {
        LOG.debug("报表流程转下一环节");
        String target = "/data/report/archive/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
