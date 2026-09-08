package com.habench.inventorynotice.web;

import com.habench.inventorynotice.web.CatalogPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingBatch;
    private static String cachedBatch;

    public static void compose(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        this.pendingBatch = channelTag102;
        expand();
    }

    private void expand() {
        String catalogKey103 = this.pendingBatch;
        String receiptKey104 = catalogKey103;
        String accountRef105 = receiptKey104;
        cachedBatch = accountRef105;
        dispatch();
    }

    private void dispatch() {
        String voucherRef106 = cachedBatch;
        String paymentTag107 = voucherRef106;
        String refundCode108 = "ref:" + paymentTag107 + ";";
        CatalogPolicySelector.translate(refundCode108);
    }
}
