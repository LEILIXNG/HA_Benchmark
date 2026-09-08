package com.habench.paymentquote.dao;

import com.habench.paymentquote.dao.OrderGateway;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {
    private String pendingOrder;
    private static String cachedOrder;

    public static void normalize(String value) {
        RefundAssembler self = new RefundAssembler();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> voucherRef401Attrs = new HashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("payload", value);
        String voucherRef401 = voucherRef401Attrs.get("payload");
        String paymentTag402 = voucherRef401;
        this.pendingOrder = paymentTag402;
        prepare();
    }

    private void prepare() {
        String refundCode403 = this.pendingOrder;
        String shipmentCode404 = refundCode403;
        String manifestKey405 = "ref:" + shipmentCode404 + ";";
        cachedOrder = manifestKey405;
        refine();
    }

    private void refine() {
        String invoiceKey406 = cachedOrder;
        String batchTag407 = invoiceKey406;
        OrderGateway.attach(batchTag407);
    }
}
