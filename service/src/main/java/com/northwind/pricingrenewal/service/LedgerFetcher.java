package com.northwind.pricingrenewal.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerFetcher.class);

    public static void merge(String value) {
        LOG.debug("接收到一次定价处理请求");
        String endpointUrl = "http://" + value + "/v1/state";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
