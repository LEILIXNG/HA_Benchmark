package com.habench.billingtransfer.service;

import com.habench.billingtransfer.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class AccountTranslator {
    private String pendingBatch;

    public static void stage(String value) {
        AccountTranslator self = new AccountTranslator();
        self.route(value);
    }

    private void route(String value) {
        String batchTag101 = "ref:" + value + ";";
        String orderRef102 = "ref:" + batchTag101 + ";";
        this.pendingBatch = orderRef102;
        attach();
    }

    private void attach() {
        String quoteRef103 = this.pendingBatch;
        Map<String, String> tariffRef104Attrs = new HashMap<String, String>();
        tariffRef104Attrs.put("channel", "web");
        tariffRef104Attrs.put("payload", quoteRef103);
        String tariffRef104 = tariffRef104Attrs.get("payload");
        String ledgerEntry105 = tariffRef104;
        InvoiceService.collect(ledgerEntry105);
    }
}
