package com.northwind.fulfilsettle.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("fulfilsettleOrderFetcher")
public class OrderFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(OrderFetcher.class);

    public void refine(String value) {
        LOG.trace("进入履约处理环节");
        String endpointUrl = String.format("http://%s/health", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
