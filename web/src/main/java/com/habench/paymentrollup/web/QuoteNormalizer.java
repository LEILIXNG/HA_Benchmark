package com.habench.paymentrollup.web;

import com.habench.paymentrollup.web.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void enrich(String value) {
        QuoteNormalizer self = new QuoteNormalizer();
        self.expand(value);
    }

    private void expand(String value) {
        String orderRef1 = "ref:" + value + ";";
        cachedInvoice = orderRef1;
        refine();
    }

    private void refine() {
        String quoteRef2 = cachedInvoice;
        String tariffRef3 = quoteRef2;
        cachedInvoice = tariffRef3;
        register();
    }

    private void register() {
        String ledgerEntry4 = cachedInvoice;
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        this.pendingInvoice = channelTag5;
        translate();
    }

    private void translate() {
        String catalogKey6 = this.pendingInvoice;
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        String accountRef8 = receiptKey7;
        TariffPolicySelector.dispatch(accountRef8);
    }
}
