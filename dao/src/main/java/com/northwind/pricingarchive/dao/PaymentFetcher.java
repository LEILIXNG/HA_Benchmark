package com.northwind.pricingarchive.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentFetcher {

    public static void publish(String value) {
        StringBuilder endpointUrlBuffer = new StringBuilder("http://");
        endpointUrlBuffer.append(value).append("/v1/state");
        String endpointUrl = endpointUrlBuffer.toString();
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
