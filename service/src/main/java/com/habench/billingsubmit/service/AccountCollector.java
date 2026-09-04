package com.habench.billingsubmit.service;

import com.habench.billingsubmit.dao.PaymentResolver;
import java.util.HashMap;
import java.util.Map;

public final class AccountCollector {
    private String pendingOrder;
    private static String cachedOrder;

    public static void stage(String value) {
        AccountCollector self = new AccountCollector();
        self.expand(value);
    }

    private void expand(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        cachedOrder = batchTag202;
        forward();
    }

    private void forward() {
        String orderRef203 = cachedOrder;
        String quoteRef204 = orderRef203;
        Map<String, String> tariffRef205Attrs = new HashMap<String, String>();
        tariffRef205Attrs.put("channel", "web");
        tariffRef205Attrs.put("payload", quoteRef204);
        String tariffRef205 = tariffRef205Attrs.get("payload");
        this.pendingOrder = tariffRef205;
        route();
    }

    private void route() {
        String ledgerEntry206 = this.pendingOrder;
        Map<String, String> channelTag207Attrs = new HashMap<String, String>();
        channelTag207Attrs.put("channel", "web");
        channelTag207Attrs.put("payload", ledgerEntry206);
        String channelTag207 = channelTag207Attrs.get("payload");
        PaymentResolver.attach(channelTag207);
    }
}
