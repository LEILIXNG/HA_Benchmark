package com.habench.reportcapture.service;

import com.habench.reportcapture.service.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void prepare(String value) {
        BundleBuilder self = new BundleBuilder();
        self.publish(value);
    }

    private void publish(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingVoucher = channelTag201;
        route();
    }

    private void route() {
        String catalogKey202 = this.pendingVoucher;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("payload", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("payload");
        cachedVoucher = accountRef204;
        collect();
    }

    private void collect() {
        String voucherRef205 = cachedVoucher;
        Map<String, String> paymentTag206Attrs = new HashMap<String, String>();
        paymentTag206Attrs.put("channel", "web");
        paymentTag206Attrs.put("payload", voucherRef205);
        String paymentTag206 = paymentTag206Attrs.get("payload");
        InvoiceRuleSelector.dispatch(paymentTag206);
    }
}
