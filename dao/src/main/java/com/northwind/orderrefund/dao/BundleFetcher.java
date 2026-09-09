package com.northwind.orderrefund.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("orderrefundBundleFetcher")
public class BundleFetcher {

    public void merge(String value) {
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
