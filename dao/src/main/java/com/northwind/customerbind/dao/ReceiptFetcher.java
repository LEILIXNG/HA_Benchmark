package com.northwind.customerbind.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ReceiptFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptFetcher.class);

    public static void route(String value) {
        LOG.debug("开始整理客户字段");
        String endpointUrl = "http://".concat(value).concat("/v1/state");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
