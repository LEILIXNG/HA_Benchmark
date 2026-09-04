package com.habench.inventoryassign.service;

import com.habench.inventoryassign.service.VoucherPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {
    private String pendingManifest;

    public static void compose(String value) {
        InvoiceRegistry self = new InvoiceRegistry();
        self.publish(value);
    }

    private void publish(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = quoteRef101;
        this.pendingManifest = tariffRef102;
        collect();
    }

    private void collect() {
        String ledgerEntry103 = this.pendingManifest;
        String channelTag104 = ledgerEntry103;
        this.pendingManifest = channelTag104;
        expand();
    }

    private void expand() {
        String catalogKey105 = this.pendingManifest;
        String receiptKey106 = "ref:" + catalogKey105 + ";";
        Map<String, String> accountRef107Attrs = new HashMap<String, String>();
        accountRef107Attrs.put("channel", "web");
        accountRef107Attrs.put("payload", receiptKey106);
        String accountRef107 = accountRef107Attrs.get("payload");
        VoucherPolicySelector.forward(accountRef107);
    }
}
