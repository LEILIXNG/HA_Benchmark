package com.northwind.catalogledger.service;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 商品受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffFetcher {

    public static void register(String value) {
        String endpointUrl = String.format("http://%s/health", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            URLConnection connection = endpoint.openConnection();
            connection.getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
