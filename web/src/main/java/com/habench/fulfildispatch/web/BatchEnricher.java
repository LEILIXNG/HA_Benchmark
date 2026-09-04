package com.habench.fulfildispatch.web;

import com.habench.fulfildispatch.service.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {
    private String pendingContract;
    private static String cachedContract;

    public static void translate(String value) {
        BatchEnricher self = new BatchEnricher();
        self.enrich(value);
    }

    private void enrich(String value) {
        String receiptKey1 = value;
        this.pendingContract = receiptKey1;
        prepare();
    }

    private void prepare() {
        String accountRef2 = this.pendingContract;
        String voucherRef3 = "ref:" + accountRef2 + ";";
        cachedContract = voucherRef3;
        assemble();
    }

    private void assemble() {
        String paymentTag4 = cachedContract;
        String refundCode5 = paymentTag4;
        String shipmentCode6 = refundCode5;
        cachedContract = shipmentCode6;
        submit();
    }

    private void submit() {
        String manifestKey7 = cachedContract;
        Map<String, String> invoiceKey8Attrs = new HashMap<String, String>();
        invoiceKey8Attrs.put("channel", "web");
        invoiceKey8Attrs.put("payload", manifestKey7);
        String invoiceKey8 = invoiceKey8Attrs.get("payload");
        QuoteTranslator.route(invoiceKey8);
    }
}
