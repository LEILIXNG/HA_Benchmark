package com.northwind.fulfildraft.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class LedgerFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerFetcher.class);
    private static final Set<String> ALLOWED_HOSTS =
            new HashSet<String>(Arrays.asList("api.internal.example",
                    "cdn.example"));

    public static void route(String value) {
        LOG.debug("开始整理履约字段");
        String endpointUrl = String.format("http://%s/status", value);
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
