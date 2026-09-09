package com.northwind.vendorlookup.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundFetcher.class);

    public static void dispatch(String value) {
        LOG.debug("供应商流程转下一环节");
        String endpointUrl = "http://" + value + "/status";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
