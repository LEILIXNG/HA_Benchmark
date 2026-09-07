package com.habench.catalogrefund.service;

import com.habench.catalogrefund.dao.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingBatch;

    public static void normalize(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String tariffRef101 = value;
        this.pendingBatch = tariffRef101;
        attach();
    }

    private void attach() {
        String ledgerEntry102 = this.pendingBatch;
        Map<String, String> channelTag103Attrs = new HashMap<String, String>();
        channelTag103Attrs.put("channel", "web");
        channelTag103Attrs.put("payload", ledgerEntry102);
        String channelTag103 = channelTag103Attrs.get("payload");
        String catalogKey104 = "ref:" + channelTag103 + ";";
        this.pendingBatch = catalogKey104;
        translate();
    }

    private void translate() {
        String receiptKey105 = this.pendingBatch;
        Map<String, String> accountRef106Attrs = new HashMap<String, String>();
        accountRef106Attrs.put("channel", "web");
        accountRef106Attrs.put("payload", receiptKey105);
        String accountRef106 = accountRef106Attrs.get("payload");
        this.pendingBatch = accountRef106;
        refine();
    }

    private void refine() {
        String voucherRef107 = this.pendingBatch;
        String paymentTag108 = "ref:" + voucherRef107 + ";";
        QuoteAssembler.attach(paymentTag108);
    }
}
