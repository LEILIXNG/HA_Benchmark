package com.habench.pricingdispatch.service;

import com.habench.pricingdispatch.service.OrderLoader;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void compose(String value) {
        VoucherTranslator self = new VoucherTranslator();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        Map<String, String> tariffRef302Attrs = new HashMap<String, String>();
        tariffRef302Attrs.put("channel", "web");
        tariffRef302Attrs.put("payload", quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get("payload");
        cachedOrder = tariffRef302;
        enrich();
    }

    private void enrich() {
        String ledgerEntry303 = cachedOrder;
        String channelTag304 = "ref:" + ledgerEntry303 + ";";
        this.pendingOrder = channelTag304;
        dispatch();
    }

    private void dispatch() {
        String catalogKey305 = this.pendingOrder;
        String receiptKey306 = "ref:" + catalogKey305 + ";";
        Map<String, String> accountRef307Attrs = new HashMap<String, String>();
        accountRef307Attrs.put("channel", "web");
        accountRef307Attrs.put("payload", receiptKey306);
        String accountRef307 = accountRef307Attrs.get("payload");
        OrderLoader.translate(accountRef307);
    }
}
