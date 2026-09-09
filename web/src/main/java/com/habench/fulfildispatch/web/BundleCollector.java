package com.habench.fulfildispatch.web;

import com.habench.fulfildispatch.web.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleCollector {
    private String pendingChannel;
    private static String cachedChannel;

    public static void route(String value) {
        BundleCollector self = new BundleCollector();
        self.assemble(value);
    }

    private void assemble(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = channelTag1;
        this.pendingChannel = catalogKey2;
        reconcile();
    }

    private void reconcile() {
        String receiptKey3 = this.pendingChannel;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        cachedChannel = accountRef4;
        register();
    }

    private void register() {
        String voucherRef5 = cachedChannel;
        Map<String, String> paymentTag6Attrs = new HashMap<String, String>();
        paymentTag6Attrs.put("channel", "web");
        paymentTag6Attrs.put("payload", voucherRef5);
        String paymentTag6 = paymentTag6Attrs.get("payload");
        ChannelRepository.resolve(paymentTag6);
    }
}
