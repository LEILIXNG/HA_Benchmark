package com.northwind.catalogposting.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("catalogpostingAccountLoader")
public class AccountLoader {
    private static final Logger LOG = LoggerFactory.getLogger(AccountLoader.class);
    private static final String ROOT = "/opt/catalog/exchange/";

    public void route(String value) {
        LOG.debug("开始整理商品字段");
        Path root = Paths.get(ROOT).toAbsolutePath().normalize();
        Path resolved = root.resolve(value).normalize();
        if (!resolved.startsWith(root)) {
            throw new IllegalArgumentException("path escapes root");
        }
        AuditTrail.emit("path", resolved.toString());
        try {
            Files.readAllLines(resolved);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
