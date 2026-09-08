package com.habench.customersplit.web;

import com.habench.customersplit.web.TariffValidator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {
    private String pendingOrder;
    private static String cachedOrder;

    public static void forward(String value) {
        VoucherAdapter self = new VoucherAdapter();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = voucherRef1;
        cachedOrder = paymentTag2;
        normalize();
    }

    private void normalize() {
        String refundCode3 = cachedOrder;
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        cachedOrder = shipmentCode4;
        assemble();
    }

    private void assemble() {
        String manifestKey5 = cachedOrder;
        Map<String, String> invoiceKey6Attrs = new HashMap<String, String>();
        invoiceKey6Attrs.put("channel", "web");
        invoiceKey6Attrs.put("payload", manifestKey5);
        String invoiceKey6 = invoiceKey6Attrs.get("payload");
        String batchTag7 = invoiceKey6;
        this.pendingOrder = batchTag7;
        prepare();
    }

    private void prepare() {
        String orderRef8 = this.pendingOrder;
        String quoteRef9 = "ref:" + orderRef8 + ";";
        String tariffRef10 = quoteRef9;
        TariffValidator.stage(tariffRef10);
    }
}
