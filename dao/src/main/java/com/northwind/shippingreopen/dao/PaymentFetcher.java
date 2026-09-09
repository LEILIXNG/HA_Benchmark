package com.northwind.shippingreopen.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("shippingreopenPaymentFetcher")
public class PaymentFetcher {

    public void collect(String value) {
        String endpointUrl = "http://" + value + "/v1/state";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
