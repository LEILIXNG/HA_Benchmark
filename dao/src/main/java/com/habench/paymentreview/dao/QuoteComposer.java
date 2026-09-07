package com.habench.paymentreview.dao;

import com.habench.paymentreview.dao.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {

    public static void prepare(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        String ledgerEntry402 = tariffRef401;
        ReceiptExecutor.register(ledgerEntry402);
    }
}
