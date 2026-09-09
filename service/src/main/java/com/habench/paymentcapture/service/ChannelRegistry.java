package com.habench.paymentcapture.service;

import com.habench.paymentcapture.service.PaymentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void publish(String value) {
        ChannelRegistry self = new ChannelRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String catalogKey101 = value;
        cachedBundle = catalogKey101;
        assemble();
    }

    private void assemble() {
        String receiptKey102 = cachedBundle;
        String accountRef103 = "ref:" + receiptKey102 + ";";
        this.pendingBundle = accountRef103;
        expand();
    }

    private void expand() {
        String voucherRef104 = this.pendingBundle;
        Map<String, String> paymentTag105Attrs = new HashMap<String, String>();
        paymentTag105Attrs.put("channel", "web");
        paymentTag105Attrs.put("payload", voucherRef104);
        String paymentTag105 = paymentTag105Attrs.get("payload");
        Map<String, String> refundCode106Attrs = new HashMap<String, String>();
        refundCode106Attrs.put("channel", "web");
        refundCode106Attrs.put("payload", paymentTag105);
        String refundCode106 = refundCode106Attrs.get("payload");
        PaymentStrategySelector.compose(refundCode106);
    }
}
