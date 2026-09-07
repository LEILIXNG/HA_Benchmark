package com.habench.vendorreview.web;

import com.habench.vendorreview.web.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private String pendingCatalog;

    public static void submit(String value) {
        ReceiptService self = new ReceiptService();
        self.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry1 = value;
        this.pendingCatalog = ledgerEntry1;
        refine();
    }

    private void refine() {
        String channelTag2 = this.pendingCatalog;
        Map<String, String> catalogKey3Attrs = new HashMap<String, String>();
        catalogKey3Attrs.put("channel", "web");
        catalogKey3Attrs.put("payload", channelTag2);
        String catalogKey3 = catalogKey3Attrs.get("payload");
        AccountPolicySelector.collect(catalogKey3);
    }
}
