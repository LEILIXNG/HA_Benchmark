package com.habench.ordermanifest.web;

import com.habench.ordermanifest.service.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void route(String value) {
        AccountAdapter self = new AccountAdapter();
        self.compose(value);
    }

    private void compose(String value) {
        String quoteRef1 = value;
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        cachedShipment = tariffRef2;
        refine();
    }

    private void refine() {
        String ledgerEntry3 = cachedShipment;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        String catalogKey5 = "ref:" + channelTag4 + ";";
        this.pendingShipment = catalogKey5;
        expand();
    }

    private void expand() {
        String receiptKey6 = this.pendingShipment;
        String accountRef7 = "ref:" + receiptKey6 + ";";
        String voucherRef8 = "ref:" + accountRef7 + ";";
        ReceiptService.expand(voucherRef8);
    }
}
