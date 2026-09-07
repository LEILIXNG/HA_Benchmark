package com.habench.pricingnotice.service;

import com.habench.pricingnotice.dao.AccountEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBroker {
    private String pendingBatch;
    private static String cachedBatch;

    public static void reconcile(String value) {
        PaymentBroker self = new PaymentBroker();
        self.expand(value);
    }

    private void expand(String value) {
        String paymentTag501 = "ref:" + value + ";";
        Map<String, String> refundCode502Attrs = new HashMap<String, String>();
        refundCode502Attrs.put("channel", "web");
        refundCode502Attrs.put("payload", paymentTag501);
        String refundCode502 = refundCode502Attrs.get("payload");
        this.pendingBatch = refundCode502;
        publish();
    }

    private void publish() {
        String shipmentCode503 = this.pendingBatch;
        String manifestKey504 = "ref:" + shipmentCode503 + ";";
        this.pendingBatch = manifestKey504;
        collect();
    }

    private void collect() {
        String invoiceKey505 = this.pendingBatch;
        String batchTag506 = "ref:" + invoiceKey505 + ";";
        String orderRef507 = batchTag506;
        cachedBatch = orderRef507;
        compose();
    }

    private void compose() {
        String quoteRef508 = cachedBatch;
        String tariffRef509 = "ref:" + quoteRef508 + ";";
        Map<String, String> ledgerEntry510Attrs = new HashMap<String, String>();
        ledgerEntry510Attrs.put("channel", "web");
        ledgerEntry510Attrs.put("payload", tariffRef509);
        String ledgerEntry510 = ledgerEntry510Attrs.get("payload");
        this.pendingBatch = ledgerEntry510;
        dispatch();
    }

    private void dispatch() {
        String channelTag511 = this.pendingBatch;
        Map<String, String> catalogKey512Attrs = new HashMap<String, String>();
        catalogKey512Attrs.put("channel", "web");
        catalogKey512Attrs.put("payload", channelTag511);
        String catalogKey512 = catalogKey512Attrs.get("payload");
        AccountEnricher.submit(catalogKey512);
    }
}
