package com.habench.accountgrant.dao;

import com.habench.accountgrant.dao.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {
    private String pendingTariff;

    public static void enrich(String value) {
        ReceiptComposer self = new ReceiptComposer();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        String refundCode302 = paymentTag301;
        this.pendingTariff = refundCode302;
        resolve();
    }

    private void resolve() {
        String shipmentCode303 = this.pendingTariff;
        String manifestKey304 = "ref:" + shipmentCode303 + ";";
        String invoiceKey305 = "ref:" + manifestKey304 + ";";
        LedgerPlanSelector.assemble(invoiceKey305);
    }
}
