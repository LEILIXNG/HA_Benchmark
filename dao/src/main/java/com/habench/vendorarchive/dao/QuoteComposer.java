package com.habench.vendorarchive.dao;

import com.habench.vendorarchive.dao.PaymentEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {
    private String pendingPayment;
    private static String cachedPayment;

    public static void compose(String value) {
        QuoteComposer self = new QuoteComposer();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> quoteRef401Attrs = new HashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("payload", value);
        String quoteRef401 = quoteRef401Attrs.get("payload");
        String tariffRef402 = quoteRef401;
        cachedPayment = tariffRef402;
        submit();
    }

    private void submit() {
        String ledgerEntry403 = cachedPayment;
        String channelTag404 = "ref:" + ledgerEntry403 + ";";
        this.pendingPayment = channelTag404;
        dispatch();
    }

    private void dispatch() {
        String catalogKey405 = this.pendingPayment;
        String receiptKey406 = catalogKey405;
        PaymentEvaluator.expand(receiptKey406);
    }
}
