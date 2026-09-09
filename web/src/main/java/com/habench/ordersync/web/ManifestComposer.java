package com.habench.ordersync.web;

import com.habench.ordersync.web.BatchRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestComposer {
    private String pendingQuote;
    private static String cachedQuote;

    public static void register(String value) {
        ManifestComposer self = new ManifestComposer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        this.pendingQuote = receiptKey1;
        submit();
    }

    private void submit() {
        String accountRef2 = this.pendingQuote;
        String voucherRef3 = "ref:" + accountRef2 + ";";
        this.pendingQuote = voucherRef3;
        refine();
    }

    private void refine() {
        String paymentTag4 = this.pendingQuote;
        Map<String, String> refundCode5Attrs = new HashMap<String, String>();
        refundCode5Attrs.put("channel", "web");
        refundCode5Attrs.put("payload", paymentTag4);
        String refundCode5 = refundCode5Attrs.get("payload");
        cachedQuote = refundCode5;
        compose();
    }

    private void compose() {
        String shipmentCode6 = cachedQuote;
        String manifestKey7 = shipmentCode6;
        String invoiceKey8 = "ref:" + manifestKey7 + ";";
        BatchRuleSelector.publish(invoiceKey8);
    }
}
