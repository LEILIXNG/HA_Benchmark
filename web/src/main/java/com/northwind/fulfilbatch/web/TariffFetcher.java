package com.northwind.fulfilbatch.web;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilbatchTariffFetcher")
public class TariffFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(TariffFetcher.class);

    public void normalize(String value) {
        LOG.debug("接收到一次履约处理请求");
        String endpointUrl = "http://".concat(value).concat("/health");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
