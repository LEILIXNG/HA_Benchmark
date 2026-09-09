package com.northwind.orderreopen.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;

/**
 * 订单受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerFetcher {

    public static void expand(String value) {
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
