package com.habench.billingtransfer.web;

import com.habench.billingtransfer.service.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void register(String value) {
        RefundTranslator self = new RefundTranslator();
        self.merge(value);
    }

    private void merge(String value) {
        String quoteRef1 = "ref:" + value + ";";
        this.pendingCatalog = quoteRef1;
        attach();
    }

    private void attach() {
        String tariffRef2 = this.pendingCatalog;
        String ledgerEntry3 = tariffRef2;
        cachedCatalog = ledgerEntry3;
        stage();
    }

    private void stage() {
        String channelTag4 = cachedCatalog;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        this.pendingCatalog = catalogKey5;
        publish();
    }

    private void publish() {
        String receiptKey6 = this.pendingCatalog;
        String accountRef7 = "ref:" + receiptKey6 + ";";
        Map<String, String> voucherRef8Attrs = new HashMap<String, String>();
        voucherRef8Attrs.put("channel", "web");
        voucherRef8Attrs.put("payload", accountRef7);
        String voucherRef8 = voucherRef8Attrs.get("payload");
        ChannelNormalizer.publish(voucherRef8);
    }
}
