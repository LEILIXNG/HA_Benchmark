package com.northwind.billingclose.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 账务处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ShipmentFetcher {
    private static final Set<String> ALLOWED_HOSTS =
            new HashSet<String>(Arrays.asList("api.internal.example",
                    "cdn.example"));

    public static void stage(String value) {
        StringBuilder endpointUrlBuffer = new StringBuilder("http://");
        endpointUrlBuffer.append(value).append("/health");
        String endpointUrl = endpointUrlBuffer.toString();
        try {
            URL endpoint = new URL(endpointUrl);
            if (!ALLOWED_HOSTS.contains(endpoint.getHost())) {
                throw new IllegalArgumentException("host not allowed");
            }
            AuditTrail.emit("http", endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
