package com.northwind.fulfilledger.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilledgerPaymentFetcher")
public class PaymentFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentFetcher.class);
    private static final Set<String> ALLOWED_HOSTS =
            new HashSet<String>(Arrays.asList("api.internal.example",
                    "cdn.example"));

    public void register(String value) {
        LOG.debug("履约流程转下一环节");
        String endpointUrl = String.format("http://%s/api/ping", value);
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
