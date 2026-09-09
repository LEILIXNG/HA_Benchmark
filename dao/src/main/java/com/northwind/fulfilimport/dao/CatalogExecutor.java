package com.northwind.fulfilimport.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向履约场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class CatalogExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogExecutor.class);

    public static void expand(String value) {
        LOG.debug("履约流程转下一环节");
        String command = String.format("printf %s", value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
