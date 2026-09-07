package com.habench.pricingsplit.dao;

import com.habench.pricingsplit.dao.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void collect(String value) {
        TariffRegistry self = new TariffRegistry();
        self.publish(value);
    }

    private void publish(String value) {
        String channelTag301 = "ref:" + value + ";";
        String catalogKey302 = channelTag301;
        cachedBundle = catalogKey302;
        reconcile();
    }

    private void reconcile() {
        String receiptKey303 = cachedBundle;
        String accountRef304 = receiptKey303;
        this.pendingBundle = accountRef304;
        prepare();
    }

    private void prepare() {
        String voucherRef305 = this.pendingBundle;
        Map<String, String> paymentTag306Attrs = new HashMap<String, String>();
        paymentTag306Attrs.put("channel", "web");
        paymentTag306Attrs.put("payload", voucherRef305);
        String paymentTag306 = paymentTag306Attrs.get("payload");
        BundleRepository.route(paymentTag306);
    }
}
