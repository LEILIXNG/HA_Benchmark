package com.habench.pricingverify.web;

import com.habench.pricingverify.service.CatalogResolver;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private String pendingSession;
    private static String cachedSession;

    public static void submit(String value) {
        OrderService self = new OrderService();
        self.compose(value);
    }

    private void compose(String value) {
        String shipmentCode1 = value;
        this.pendingSession = shipmentCode1;
        forward();
    }

    private void forward() {
        String manifestKey2 = this.pendingSession;
        String invoiceKey3 = "ref:" + manifestKey2 + ";";
        cachedSession = invoiceKey3;
        collect();
    }

    private void collect() {
        String batchTag4 = cachedSession;
        String orderRef5 = batchTag4;
        Map<String, String> quoteRef6Attrs = new HashMap<String, String>();
        quoteRef6Attrs.put("channel", "web");
        quoteRef6Attrs.put("payload", orderRef5);
        String quoteRef6 = quoteRef6Attrs.get("payload");
        this.pendingSession = quoteRef6;
        enrich();
    }

    private void enrich() {
        String tariffRef7 = this.pendingSession;
        String ledgerEntry8 = "ref:" + tariffRef7 + ";";
        cachedSession = ledgerEntry8;
        register();
    }

    private void register() {
        String channelTag9 = cachedSession;
        String catalogKey10 = "ref:" + channelTag9 + ";";
        String receiptKey11 = catalogKey10;
        CatalogResolver.dispatch(receiptKey11);
    }
}
