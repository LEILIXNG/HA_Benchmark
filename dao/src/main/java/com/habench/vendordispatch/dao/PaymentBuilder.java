package com.habench.vendordispatch.dao;

import com.habench.vendordispatch.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private String pendingOrder;
    private static String cachedOrder;

    public static void reconcile(String value) {
        PaymentBuilder self = new PaymentBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        String voucherRef301 = value;
        String paymentTag302 = voucherRef301;
        cachedOrder = paymentTag302;
        collect();
    }

    private void collect() {
        String refundCode303 = cachedOrder;
        Map<String, String> shipmentCode304Attrs = new HashMap<String, String>();
        shipmentCode304Attrs.put("channel", "web");
        shipmentCode304Attrs.put("payload", refundCode303);
        String shipmentCode304 = shipmentCode304Attrs.get("payload");
        this.pendingOrder = shipmentCode304;
        enrich();
    }

    private void enrich() {
        String manifestKey305 = this.pendingOrder;
        String invoiceKey306 = "ref:" + manifestKey305 + ";";
        OrderRepository.collect(invoiceKey306);
    }
}
