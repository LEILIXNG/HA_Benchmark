package com.habench.catalognotice.service;

import com.habench.catalognotice.dao.InvoiceAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {
    private String pendingOrder;

    public static void collect(String value) {
        AccountService self = new AccountService();
        self.assemble(value);
    }

    private void assemble(String value) {
        String channelTag101 = "ref:" + value + ";";
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        this.pendingOrder = catalogKey102;
        refine();
    }

    private void refine() {
        String receiptKey103 = this.pendingOrder;
        String accountRef104 = receiptKey103;
        InvoiceAdapter.refine(accountRef104);
    }
}
