package com.habench.paymentnotice.web;

import com.habench.paymentnotice.service.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {
    private String pendingChannel;
    private static String cachedChannel;

    public static void dispatch(String value) {
        ReceiptEnricher self = new ReceiptEnricher();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        this.pendingChannel = ledgerEntry102;
        route();
    }

    private void route() {
        String channelTag103 = this.pendingChannel;
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        String receiptKey105 = catalogKey104;
        this.pendingChannel = receiptKey105;
        translate();
    }

    private void translate() {
        String accountRef106 = this.pendingChannel;
        String voucherRef107 = "ref:" + accountRef106 + ";";
        cachedChannel = voucherRef107;
        submit();
    }

    private void submit() {
        String paymentTag108 = cachedChannel;
        String refundCode109 = paymentTag108;
        QuoteAssembler.merge(refundCode109);
    }
}
