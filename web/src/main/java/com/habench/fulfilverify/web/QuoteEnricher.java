package com.habench.fulfilverify.web;

import com.habench.fulfilverify.web.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {
    private String pendingInvoice;

    public static void compose(String value) {
        QuoteEnricher self = new QuoteEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String tariffRef1 = "ref:" + value + ";";
        this.pendingInvoice = tariffRef1;
        forward();
    }

    private void forward() {
        String ledgerEntry2 = this.pendingInvoice;
        Map<String, String> channelTag3Attrs = new HashMap<String, String>();
        channelTag3Attrs.put("channel", "web");
        channelTag3Attrs.put("payload", ledgerEntry2);
        String channelTag3 = channelTag3Attrs.get("payload");
        String catalogKey4 = "ref:" + channelTag3 + ";";
        this.pendingInvoice = catalogKey4;
        dispatch();
    }

    private void dispatch() {
        String receiptKey5 = this.pendingInvoice;
        String accountRef6 = "ref:" + receiptKey5 + ";";
        String voucherRef7 = accountRef6;
        QuoteAssembler.reconcile(voucherRef7);
    }
}
