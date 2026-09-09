package com.habench.billingassign.web;

import com.habench.billingassign.web.ContractStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {
    private String pendingQuote;
    private static String cachedQuote;

    public static void dispatch(String value) {
        ManifestAssembler self = new ManifestAssembler();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        this.pendingQuote = receiptKey1;
        collect();
    }

    private void collect() {
        String accountRef2 = this.pendingQuote;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        cachedQuote = voucherRef3;
        register();
    }

    private void register() {
        String paymentTag4 = cachedQuote;
        Map<String, String> refundCode5Attrs = new HashMap<String, String>();
        refundCode5Attrs.put("channel", "web");
        refundCode5Attrs.put("payload", paymentTag4);
        String refundCode5 = refundCode5Attrs.get("payload");
        this.pendingQuote = refundCode5;
        translate();
    }

    private void translate() {
        String shipmentCode6 = this.pendingQuote;
        Map<String, String> manifestKey7Attrs = new HashMap<String, String>();
        manifestKey7Attrs.put("channel", "web");
        manifestKey7Attrs.put("payload", shipmentCode6);
        String manifestKey7 = manifestKey7Attrs.get("payload");
        String invoiceKey8 = "ref:" + manifestKey7 + ";";
        ContractStrategySelector.collect(invoiceKey8);
    }
}
