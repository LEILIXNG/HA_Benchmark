package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.web.AccountLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingAccount;
    private static String cachedAccount;

    public static void normalize(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.prepare(value);
    }

    private void prepare(String value) {
        String tariffRef1 = "ref:" + value + ";";
        String ledgerEntry2 = tariffRef1;
        cachedAccount = ledgerEntry2;
        enrich();
    }

    private void enrich() {
        String channelTag3 = cachedAccount;
        String catalogKey4 = channelTag3;
        this.pendingAccount = catalogKey4;
        compose();
    }

    private void compose() {
        String receiptKey5 = this.pendingAccount;
        String accountRef6 = "ref:" + receiptKey5 + ";";
        Map<String, String> voucherRef7Attrs = new HashMap<String, String>();
        voucherRef7Attrs.put("channel", "web");
        voucherRef7Attrs.put("payload", accountRef6);
        String voucherRef7 = voucherRef7Attrs.get("payload");
        AccountLoader.route(voucherRef7);
    }
}
