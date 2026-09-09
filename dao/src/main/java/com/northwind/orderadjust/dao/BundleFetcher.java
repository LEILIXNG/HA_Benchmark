package com.northwind.orderadjust.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleFetcher {

    public static void dispatch(String value) {
        StringBuilder endpointUrlBuffer = new StringBuilder("http://");
        endpointUrlBuffer.append(value).append("/api/ping");
        String endpointUrl = endpointUrlBuffer.toString();
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
