package com.northwind.paymentintake.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.springframework.stereotype.Repository;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("paymentintakeVoucherFetcher")
public class VoucherFetcher {

    public void enrich(String value) {
        String endpointUrl = String.format("http://%s/v1/state", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
