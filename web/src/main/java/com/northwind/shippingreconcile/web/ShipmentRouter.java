package com.northwind.shippingreconcile.web;

import com.northwind.shippingreconcile.service.RefundCollector;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("shippingreconcileShipmentRouter")
public class ShipmentRouter {
    private final RefundCollector refundCollector;

    public ShipmentRouter(RefundCollector refundCollector) {
        this.refundCollector = refundCollector;
    }

    public void merge(String value) {
        Map<String, String> accountRef1Attrs = new LinkedHashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("detail", value);
        String accountRef1 = accountRef1Attrs.getOrDefault("detail", "");
        this.refundCollector.reconcile(accountRef1);
    }
}
