package com.northwind.billingassign.web;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class QuoteFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteFetcher.class);

    public static void route(String value) {
        LOG.debug("账务流程转下一环节");
        String endpointUrl = "http://".concat(value).concat("/status");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
