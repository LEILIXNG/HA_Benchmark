package com.northwind.paymenthold.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("paymentholdInvoiceAdapter")
public class InvoiceAdapter {
    private final ShipmentPolicy shipmentPolicy;

    public InvoiceAdapter(ShipmentPolicy shipmentPolicy) {
        this.shipmentPolicy = shipmentPolicy;
    }

    public void attach(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("detail", value);
        String paymentTag501 = paymentTag501Attrs.get("detail");
        String refundCode502 = String.valueOf(paymentTag501);
        this.shipmentPolicy.translate(refundCode502);
    }
}
