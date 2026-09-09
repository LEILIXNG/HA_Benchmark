package com.northwind.inventoryrefund.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("inventoryrefundInvoiceLoader")
public class InvoiceLoader {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceLoader.class);
    private static final String ROOT = "/data/inventory/archive/";

    public void compose(String value) {
        LOG.debug("库存流程转下一环节");
        StringBuilder targetBuffer = new StringBuilder("/data/inventory/archive/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
