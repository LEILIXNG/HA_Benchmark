package com.habench.paymentsettle.web;

import com.habench.paymentsettle.web.QuoteCollector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {
    private String pendingTariff;

    public static void dispatch(String value) {
        InvoiceBroker self = new InvoiceBroker();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        this.pendingTariff = channelTag2;
        collect();
    }

    private void collect() {
        String catalogKey3 = this.pendingTariff;
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        QuoteCollector.normalize(receiptKey4);
    }
}
