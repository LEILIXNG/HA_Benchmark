package com.northwind.fulfilcapture.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class TariffLoader {
    private static final Logger LOG = LoggerFactory.getLogger(TariffLoader.class);
    private static final String ROOT = "/data/fulfil/archive/";

    public static void expand(String value) {
        LOG.debug("履约流程转下一环节");
        String target = "/data/fulfil/archive/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
