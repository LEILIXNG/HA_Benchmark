package com.habench.billingtransfer.service;

import com.habench.billingtransfer.service.CatalogGateway;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void publish(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.register(value);
    }

    private void register(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        this.pendingCatalog = shipmentCode101;
        dispatch();
    }

    private void dispatch() {
        String manifestKey102 = this.pendingCatalog;
        String invoiceKey103 = manifestKey102;
        cachedCatalog = invoiceKey103;
        enrich();
    }

    private void enrich() {
        String batchTag104 = cachedCatalog;
        String orderRef105 = "ref:" + batchTag104 + ";";
        this.pendingCatalog = orderRef105;
        attach();
    }

    private void attach() {
        String quoteRef106 = this.pendingCatalog;
        String tariffRef107 = "ref:" + quoteRef106 + ";";
        cachedCatalog = tariffRef107;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry108 = cachedCatalog;
        Map<String, String> channelTag109Attrs = new HashMap<String, String>();
        channelTag109Attrs.put("channel", "web");
        channelTag109Attrs.put("payload", ledgerEntry108);
        String channelTag109 = channelTag109Attrs.get("payload");
        String catalogKey110 = "ref:" + channelTag109 + ";";
        this.pendingCatalog = catalogKey110;
        stage();
    }

    private void stage() {
        String receiptKey111 = this.pendingCatalog;
        String accountRef112 = receiptKey111;
        String voucherRef113 = accountRef112;
        CatalogGateway.enrich(voucherRef113);
    }
}
