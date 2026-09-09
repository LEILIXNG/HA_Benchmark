package com.northwind.inventoryhold.web;

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
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BundleLoader.class);
    private static final String ROOT = "/var/lib/inventory/data/";

    public static void stage(String value) {
        LOG.debug("接收到一次库存处理请求");
        String target = String.format("/var/lib/inventory/data/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
