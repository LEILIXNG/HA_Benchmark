package com.habench.customersettle.dao;

import com.habench.customersettle.dao.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {
    private String pendingBundle;
    private static String cachedBundle;

    public static void register(String value) {
        ChannelResolver self = new ChannelResolver();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        String manifestKey302 = "ref:" + shipmentCode301 + ";";
        cachedBundle = manifestKey302;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey303 = cachedBundle;
        String batchTag304 = "ref:" + invoiceKey303 + ";";
        this.pendingBundle = batchTag304;
        stage();
    }

    private void stage() {
        String orderRef305 = this.pendingBundle;
        String quoteRef306 = orderRef305;
        String tariffRef307 = "ref:" + quoteRef306 + ";";
        this.pendingBundle = tariffRef307;
        collect();
    }

    private void collect() {
        String ledgerEntry308 = this.pendingBundle;
        Map<String, String> channelTag309Attrs = new HashMap<String, String>();
        channelTag309Attrs.put("channel", "web");
        channelTag309Attrs.put("payload", ledgerEntry308);
        String channelTag309 = channelTag309Attrs.get("payload");
        Map<String, String> catalogKey310Attrs = new HashMap<String, String>();
        catalogKey310Attrs.put("channel", "web");
        catalogKey310Attrs.put("payload", channelTag309);
        String catalogKey310 = catalogKey310Attrs.get("payload");
        cachedBundle = catalogKey310;
        enrich();
    }

    private void enrich() {
        String receiptKey311 = cachedBundle;
        Map<String, String> accountRef312Attrs = new HashMap<String, String>();
        accountRef312Attrs.put("channel", "web");
        accountRef312Attrs.put("payload", receiptKey311);
        String accountRef312 = accountRef312Attrs.get("payload");
        Map<String, String> voucherRef313Attrs = new HashMap<String, String>();
        voucherRef313Attrs.put("channel", "web");
        voucherRef313Attrs.put("payload", accountRef312);
        String voucherRef313 = voucherRef313Attrs.get("payload");
        InvoicePlanSelector.resolve(voucherRef313);
    }
}
