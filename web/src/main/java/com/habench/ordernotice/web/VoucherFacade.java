package com.habench.ordernotice.web;

import com.habench.ordernotice.service.QuoteAdapter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void enrich(String value) {
        VoucherFacade self = new VoucherFacade();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        this.pendingCatalog = ledgerEntry1;
        merge();
    }

    private void merge() {
        String channelTag2 = this.pendingCatalog;
        Map<String, String> catalogKey3Attrs = new HashMap<String, String>();
        catalogKey3Attrs.put("channel", "web");
        catalogKey3Attrs.put("payload", channelTag2);
        String catalogKey3 = catalogKey3Attrs.get("payload");
        cachedCatalog = catalogKey3;
        collect();
    }

    private void collect() {
        String receiptKey4 = cachedCatalog;
        String accountRef5 = "ref:" + receiptKey4 + ";";
        String voucherRef6 = "ref:" + accountRef5 + ";";
        QuoteAdapter.attach(voucherRef6);
    }
}
