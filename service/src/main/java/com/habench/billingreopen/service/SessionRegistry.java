package com.habench.billingreopen.service;

import com.habench.billingreopen.service.BundleService;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingChannel;

    public static void merge(String value) {
        SessionRegistry self = new SessionRegistry();
        self.translate(value);
    }

    private void translate(String value) {
        String catalogKey201 = "ref:" + value + ";";
        this.pendingChannel = catalogKey201;
        attach();
    }

    private void attach() {
        String receiptKey202 = this.pendingChannel;
        String accountRef203 = "ref:" + receiptKey202 + ";";
        this.pendingChannel = accountRef203;
        normalize();
    }

    private void normalize() {
        String voucherRef204 = this.pendingChannel;
        Map<String, String> paymentTag205Attrs = new HashMap<String, String>();
        paymentTag205Attrs.put("channel", "web");
        paymentTag205Attrs.put("payload", voucherRef204);
        String paymentTag205 = paymentTag205Attrs.get("payload");
        String refundCode206 = "ref:" + paymentTag205 + ";";
        BundleService.submit(refundCode206);
    }
}
