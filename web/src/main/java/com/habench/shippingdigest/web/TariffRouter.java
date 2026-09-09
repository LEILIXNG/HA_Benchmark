package com.habench.shippingdigest.web;

import com.habench.shippingdigest.service.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {
    private String pendingLedger;
    private static String cachedLedger;

    public static void merge(String value) {
        TariffRouter self = new TariffRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        String paymentTag1 = value;
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        cachedLedger = refundCode2;
        register();
    }

    private void register() {
        String shipmentCode3 = cachedLedger;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        cachedLedger = invoiceKey5;
        dispatch();
    }

    private void dispatch() {
        String batchTag6 = cachedLedger;
        String orderRef7 = batchTag6;
        cachedLedger = orderRef7;
        resolve();
    }

    private void resolve() {
        String quoteRef8 = cachedLedger;
        String tariffRef9 = quoteRef8;
        String ledgerEntry10 = tariffRef9;
        this.pendingLedger = ledgerEntry10;
        prepare();
    }

    private void prepare() {
        String channelTag11 = this.pendingLedger;
        Map<String, String> catalogKey12Attrs = new HashMap<String, String>();
        catalogKey12Attrs.put("channel", "web");
        catalogKey12Attrs.put("payload", channelTag11);
        String catalogKey12 = catalogKey12Attrs.get("payload");
        BatchComposer.enrich(catalogKey12);
    }
}
