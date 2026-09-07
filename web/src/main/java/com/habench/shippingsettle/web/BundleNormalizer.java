package com.habench.shippingsettle.web;

import com.habench.shippingsettle.web.ManifestValidator;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {
    private String pendingTariff;
    private static String cachedTariff;

    public static void submit(String value) {
        BundleNormalizer self = new BundleNormalizer();
        self.expand(value);
    }

    private void expand(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        cachedTariff = ledgerEntry2;
        collect();
    }

    private void collect() {
        String channelTag3 = cachedTariff;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        this.pendingTariff = catalogKey4;
        attach();
    }

    private void attach() {
        String receiptKey5 = this.pendingTariff;
        Map<String, String> accountRef6Attrs = new HashMap<String, String>();
        accountRef6Attrs.put("channel", "web");
        accountRef6Attrs.put("payload", receiptKey5);
        String accountRef6 = accountRef6Attrs.get("payload");
        ManifestValidator.attach(accountRef6);
    }
}
