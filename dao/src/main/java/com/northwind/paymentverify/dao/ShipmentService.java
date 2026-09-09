package com.northwind.paymentverify.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("paymentverifyShipmentService")
public class ShipmentService {
    private final InvoiceGateway invoiceGateway;

    public ShipmentService(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    public void reconcile(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("detail", value);
        String catalogKey301 = catalogKey301Attrs.get("detail");
        Map<String, String> receiptKey302Attrs = new HashMap<String, String>();
        receiptKey302Attrs.put("channel", "web");
        receiptKey302Attrs.put("remark", catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get("remark");
        this.invoiceGateway.forward(receiptKey302);
    }
}
