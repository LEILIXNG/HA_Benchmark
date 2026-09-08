package com.habench.billinggrant.web;

import com.habench.billinggrant.service.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void translate(String value) {
        PaymentRouter self = new PaymentRouter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = accountRef1;
        cachedShipment = voucherRef2;
        refine();
    }

    private void refine() {
        String paymentTag3 = cachedShipment;
        String refundCode4 = paymentTag3;
        this.pendingShipment = refundCode4;
        assemble();
    }

    private void assemble() {
        String shipmentCode5 = this.pendingShipment;
        String manifestKey6 = "ref:" + shipmentCode5 + ";";
        Map<String, String> invoiceKey7Attrs = new HashMap<String, String>();
        invoiceKey7Attrs.put("channel", "web");
        invoiceKey7Attrs.put("payload", manifestKey6);
        String invoiceKey7 = invoiceKey7Attrs.get("payload");
        ReceiptService.expand(invoiceKey7);
    }
}
