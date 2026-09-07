package com.habench.catalogrenewal.service;

import com.habench.catalogrenewal.service.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRouter {
    private String pendingContract;

    public static void normalize(String value) {
        LedgerRouter self = new LedgerRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        this.pendingContract = catalogKey201;
        collect();
    }

    private void collect() {
        String receiptKey202 = this.pendingContract;
        Map<String, String> accountRef203Attrs = new HashMap<String, String>();
        accountRef203Attrs.put("channel", "web");
        accountRef203Attrs.put("payload", receiptKey202);
        String accountRef203 = accountRef203Attrs.get("payload");
        String voucherRef204 = accountRef203;
        ManifestService.assemble(voucherRef204);
    }
}
