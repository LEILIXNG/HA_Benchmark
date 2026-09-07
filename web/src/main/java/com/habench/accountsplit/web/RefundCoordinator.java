package com.habench.accountsplit.web;

import com.habench.accountsplit.service.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {
    private String pendingShipment;
    private static String cachedShipment;

    public static void forward(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedShipment = quoteRef1;
        dispatch();
    }

    private void dispatch() {
        String tariffRef2 = cachedShipment;
        String ledgerEntry3 = "ref:" + tariffRef2 + ";";
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        this.pendingShipment = channelTag4;
        register();
    }

    private void register() {
        String catalogKey5 = this.pendingShipment;
        String receiptKey6 = catalogKey5;
        Map<String, String> accountRef7Attrs = new HashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("payload", receiptKey6);
        String accountRef7 = accountRef7Attrs.get("payload");
        QuoteService.compose(accountRef7);
    }
}
