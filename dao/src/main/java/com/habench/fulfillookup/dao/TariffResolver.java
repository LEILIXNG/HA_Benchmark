package com.habench.fulfillookup.dao;

import com.habench.fulfillookup.dao.VoucherFilter;
import java.util.HashMap;
import java.util.Map;

public final class TariffResolver {
    private String pendingPayment;

    public static void route(String value) {
        TariffResolver self = new TariffResolver();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        this.pendingPayment = channelTag202;
        reconcile();
    }

    private void reconcile() {
        String catalogKey203 = this.pendingPayment;
        String receiptKey204 = catalogKey203;
        String accountRef205 = receiptKey204;
        VoucherFilter.attach(accountRef205);
    }
}
