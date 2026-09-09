package com.northwind.fulfilsync.dao;

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
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentLoader.class);
    private static final String ROOT = "/opt/fulfil/exchange/";

    public static void refine(String value) {
        LOG.debug("开始整理履约字段");
        String target = String.format("/opt/fulfil/exchange/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
