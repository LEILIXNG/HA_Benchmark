package com.northwind.reportexport.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentFetcher {

    public static void compose(String value) {
        String endpointUrl = "http://".concat(value).concat("/health");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
