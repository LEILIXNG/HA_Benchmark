package com.habench.pricingcapture.service;

import com.habench.pricingcapture.dao.PaymentResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {
    private String pendingContract;
    private static String cachedContract;

    public static void attach(String value) {
        ManifestEnricher self = new ManifestEnricher();
        self.publish(value);
    }

    private void publish(String value) {
        String tariffRef201 = "ref:" + value + ";";
        String ledgerEntry202 = tariffRef201;
        this.pendingContract = ledgerEntry202;
        prepare();
    }

    private void prepare() {
        String channelTag203 = this.pendingContract;
        String catalogKey204 = channelTag203;
        cachedContract = catalogKey204;
        normalize();
    }

    private void normalize() {
        String receiptKey205 = cachedContract;
        Map<String, String> accountRef206Attrs = new HashMap<String, String>();
        accountRef206Attrs.put("channel", "web");
        accountRef206Attrs.put("payload", receiptKey205);
        String accountRef206 = accountRef206Attrs.get("payload");
        String voucherRef207 = accountRef206;
        PaymentResolver.refine(voucherRef207);
    }
}
