package com.northwind.pricingposting.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.stereotype.Service;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("pricingpostingBatchFetcher")
public class BatchFetcher {

    public void merge(String value) {
        String endpointUrl = String.format("http://%s/status", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            URLConnection connection = endpoint.openConnection();
            connection.getInputStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
