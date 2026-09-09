package com.northwind.fulfilexport.service;

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
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BundleLoader.class);
    private static final String ROOT = "/var/lib/fulfil/data/";

    public static void reconcile(String value) {
        LOG.debug("接收到一次履约处理请求");
        String target = String.format("/var/lib/fulfil/data/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
