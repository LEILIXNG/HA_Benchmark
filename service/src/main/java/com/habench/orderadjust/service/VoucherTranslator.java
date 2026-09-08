package com.habench.orderadjust.service;

import com.habench.orderadjust.dao.ReceiptAdapter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {
    private String pendingBundle;

    public static void collect(String value) {
        VoucherTranslator self = new VoucherTranslator();
        self.route(value);
    }

    private void route(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        String channelTag102 = ledgerEntry101;
        this.pendingBundle = channelTag102;
        attach();
    }

    private void attach() {
        String catalogKey103 = this.pendingBundle;
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        Map<String, String> accountRef105Attrs = new HashMap<String, String>();
        accountRef105Attrs.put("channel", "web");
        accountRef105Attrs.put("payload", receiptKey104);
        String accountRef105 = accountRef105Attrs.get("payload");
        ReceiptAdapter.dispatch(accountRef105);
    }
}
