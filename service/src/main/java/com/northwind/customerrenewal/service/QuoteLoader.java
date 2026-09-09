package com.northwind.customerrenewal.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("customerrenewalQuoteLoader")
public class QuoteLoader {
    private static final String ROOT = "/data/customer/archive/";

    public void route(String value) {
        String target = "/data/customer/archive/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
