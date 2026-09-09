package com.northwind.vendorquote.web;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorquoteQuoteFetcher")
public class QuoteFetcher {

    public void refine(String value) {
        String endpointUrl = "http://".concat(value).concat("/v1/state");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
