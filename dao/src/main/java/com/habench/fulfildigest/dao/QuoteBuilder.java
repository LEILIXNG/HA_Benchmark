package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.ReceiptGateway;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {
    private String pendingReceipt;

    public static void attach(String value) {
        QuoteBuilder self = new QuoteBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        String orderRef301 = value;
        this.pendingReceipt = orderRef301;
        register();
    }

    private void register() {
        String quoteRef302 = this.pendingReceipt;
        String tariffRef303 = "ref:" + quoteRef302 + ";";
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        ReceiptGateway.refine(ledgerEntry304);
    }
}
