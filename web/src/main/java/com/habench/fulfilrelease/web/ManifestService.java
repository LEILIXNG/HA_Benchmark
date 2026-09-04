package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {
    private String pendingTariff;
    private static String cachedTariff;

    public static void expand(String value) {
        ManifestService self = new ManifestService();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        this.pendingTariff = channelTag1;
        publish();
    }

    private void publish() {
        String catalogKey2 = this.pendingTariff;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        cachedTariff = receiptKey3;
        stage();
    }

    private void stage() {
        String accountRef4 = cachedTariff;
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        String paymentTag6 = "ref:" + voucherRef5 + ";";
        TariffRepository.attach(paymentTag6);
    }
}
