package com.habench.accountrenewal.web;

import com.habench.accountrenewal.web.BatchNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {
    private String pendingContract;
    private static String cachedContract;

    public static void publish(String value) {
        AccountAdapter self = new AccountAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        this.pendingContract = quoteRef1;
        merge();
    }

    private void merge() {
        String tariffRef2 = this.pendingContract;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = ledgerEntry3;
        this.pendingContract = channelTag4;
        collect();
    }

    private void collect() {
        String catalogKey5 = this.pendingContract;
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("payload", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("payload");
        cachedContract = receiptKey6;
        submit();
    }

    private void submit() {
        String accountRef7 = cachedContract;
        String voucherRef8 = accountRef7;
        BatchNormalizer.submit(voucherRef8);
    }
}
