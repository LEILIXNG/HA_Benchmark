package com.habench.inventoryissue.service;

import com.habench.inventoryissue.service.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {
    private String pendingQuote;
    private static String cachedQuote;

    public static void dispatch(String value) {
        AccountAssembler self = new AccountAssembler();
        self.submit(value);
    }

    private void submit(String value) {
        String ledgerEntry201 = value;
        String channelTag202 = ledgerEntry201;
        this.pendingQuote = channelTag202;
        compose();
    }

    private void compose() {
        String catalogKey203 = this.pendingQuote;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        cachedQuote = receiptKey204;
        resolve();
    }

    private void resolve() {
        String accountRef205 = cachedQuote;
        String voucherRef206 = "ref:" + accountRef205 + ";";
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        AccountStrategySelector.route(paymentTag207);
    }
}
