package com.habench.fulfildraft.web;

import com.habench.fulfildraft.web.LedgerFetcher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private String pendingLedger;
    private static String cachedLedger;

    public static void collect(String value) {
        PaymentRouter self = new PaymentRouter();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry1 = value;
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        cachedLedger = channelTag2;
        register();
    }

    private void register() {
        String catalogKey3 = cachedLedger;
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        Map<String, String> accountRef5Attrs = new HashMap<String, String>();
        accountRef5Attrs.put("channel", "web");
        accountRef5Attrs.put("payload", receiptKey4);
        String accountRef5 = accountRef5Attrs.get("payload");
        this.pendingLedger = accountRef5;
        reconcile();
    }

    private void reconcile() {
        String voucherRef6 = this.pendingLedger;
        Map<String, String> paymentTag7Attrs = new HashMap<String, String>();
        paymentTag7Attrs.put("channel", "web");
        paymentTag7Attrs.put("payload", voucherRef6);
        String paymentTag7 = paymentTag7Attrs.get("payload");
        String refundCode8 = paymentTag7;
        LedgerFetcher.route(refundCode8);
    }
}
