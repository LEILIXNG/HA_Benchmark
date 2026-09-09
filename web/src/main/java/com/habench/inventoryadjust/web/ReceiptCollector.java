package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.service.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingShipment;
    private static String cachedShipment;

    public static void collect(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.refine(value);
    }

    private void refine(String value) {
        String orderRef1 = value;
        cachedShipment = orderRef1;
        reconcile();
    }

    private void reconcile() {
        String quoteRef2 = cachedShipment;
        Map<String, String> tariffRef3Attrs = new HashMap<String, String>();
        tariffRef3Attrs.put("channel", "web");
        tariffRef3Attrs.put("payload", quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get("payload");
        this.pendingShipment = tariffRef3;
        stage();
    }

    private void stage() {
        String ledgerEntry4 = this.pendingShipment;
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        String catalogKey6 = "ref:" + channelTag5 + ";";
        this.pendingShipment = catalogKey6;
        resolve();
    }

    private void resolve() {
        String receiptKey7 = this.pendingShipment;
        String accountRef8 = "ref:" + receiptKey7 + ";";
        String voucherRef9 = accountRef8;
        QuoteTranslator.stage(voucherRef9);
    }
}
