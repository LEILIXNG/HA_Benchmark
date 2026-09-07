package com.habench.orderreopen.web;

import com.habench.orderreopen.web.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountNormalizer {
    private String pendingTariff;
    private static String cachedTariff;

    public static void register(String value) {
        AccountNormalizer self = new AccountNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String refundCode1 = value;
        this.pendingTariff = refundCode1;
        publish();
    }

    private void publish() {
        String shipmentCode2 = this.pendingTariff;
        String manifestKey3 = shipmentCode2;
        String invoiceKey4 = manifestKey3;
        cachedTariff = invoiceKey4;
        forward();
    }

    private void forward() {
        String batchTag5 = cachedTariff;
        String orderRef6 = batchTag5;
        cachedTariff = orderRef6;
        dispatch();
    }

    private void dispatch() {
        String quoteRef7 = cachedTariff;
        String tariffRef8 = "ref:" + quoteRef7 + ";";
        Map<String, String> ledgerEntry9Attrs = new HashMap<String, String>();
        ledgerEntry9Attrs.put("channel", "web");
        ledgerEntry9Attrs.put("payload", tariffRef8);
        String ledgerEntry9 = ledgerEntry9Attrs.get("payload");
        cachedTariff = ledgerEntry9;
        collect();
    }

    private void collect() {
        String channelTag10 = cachedTariff;
        String catalogKey11 = "ref:" + channelTag10 + ";";
        String receiptKey12 = "ref:" + catalogKey11 + ";";
        AccountPolicySelector.enrich(receiptKey12);
    }
}
