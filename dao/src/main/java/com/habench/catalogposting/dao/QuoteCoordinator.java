package com.habench.catalogposting.dao;

import com.habench.catalogposting.dao.LedgerEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {
    private String pendingLedger;
    private static String cachedLedger;

    public static void resolve(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        cachedLedger = invoiceKey201;
        register();
    }

    private void register() {
        String batchTag202 = cachedLedger;
        String orderRef203 = "ref:" + batchTag202 + ";";
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        this.pendingLedger = quoteRef204;
        route();
    }

    private void route() {
        String tariffRef205 = this.pendingLedger;
        Map<String, String> ledgerEntry206Attrs = new HashMap<String, String>();
        ledgerEntry206Attrs.put("channel", "web");
        ledgerEntry206Attrs.put("payload", tariffRef205);
        String ledgerEntry206 = ledgerEntry206Attrs.get("payload");
        String channelTag207 = ledgerEntry206;
        LedgerEvaluator.resolve(channelTag207);
    }
}
