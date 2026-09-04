package com.habench.accountexport.dao;

import com.habench.accountexport.dao.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {
    private String pendingPayment;
    private static String cachedPayment;

    public static void collect(String value) {
        QuoteRegistry self = new QuoteRegistry();
        self.publish(value);
    }

    private void publish(String value) {
        String orderRef201 = "ref:" + value + ";";
        String quoteRef202 = "ref:" + orderRef201 + ";";
        cachedPayment = quoteRef202;
        dispatch();
    }

    private void dispatch() {
        String tariffRef203 = cachedPayment;
        Map<String, String> ledgerEntry204Attrs = new HashMap<String, String>();
        ledgerEntry204Attrs.put("channel", "web");
        ledgerEntry204Attrs.put("payload", tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get("payload");
        this.pendingPayment = ledgerEntry204;
        merge();
    }

    private void merge() {
        String channelTag205 = this.pendingPayment;
        String catalogKey206 = channelTag205;
        Map<String, String> receiptKey207Attrs = new HashMap<String, String>();
        receiptKey207Attrs.put("channel", "web");
        receiptKey207Attrs.put("payload", catalogKey206);
        String receiptKey207 = receiptKey207Attrs.get("payload");
        PaymentLoader.forward(receiptKey207);
    }
}
