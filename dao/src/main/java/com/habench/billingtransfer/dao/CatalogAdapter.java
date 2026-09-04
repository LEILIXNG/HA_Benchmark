package com.habench.billingtransfer.dao;

import com.habench.billingtransfer.dao.ChannelPolicy;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAdapter {
    private String pendingBatch;
    private static String cachedBatch;

    public static void refine(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String channelTag301 = "ref:" + value + ";";
        this.pendingBatch = channelTag301;
        submit();
    }

    private void submit() {
        String catalogKey302 = this.pendingBatch;
        Map<String, String> receiptKey303Attrs = new HashMap<String, String>();
        receiptKey303Attrs.put("channel", "web");
        receiptKey303Attrs.put("payload", catalogKey302);
        String receiptKey303 = receiptKey303Attrs.get("payload");
        String accountRef304 = "ref:" + receiptKey303 + ";";
        cachedBatch = accountRef304;
        enrich();
    }

    private void enrich() {
        String voucherRef305 = cachedBatch;
        String paymentTag306 = voucherRef305;
        ChannelPolicy.normalize(paymentTag306);
    }
}
