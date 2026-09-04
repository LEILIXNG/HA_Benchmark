package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private String pendingLedger;
    private static String cachedLedger;

    public static void translate(String value) {
        ShipmentEnricher self = new ShipmentEnricher();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedLedger = quoteRef2;
        enrich();
    }

    private void enrich() {
        String tariffRef3 = cachedLedger;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        cachedLedger = channelTag5;
        forward();
    }

    private void forward() {
        String catalogKey6 = cachedLedger;
        String receiptKey7 = catalogKey6;
        cachedLedger = receiptKey7;
        prepare();
    }

    private void prepare() {
        String accountRef8 = cachedLedger;
        String voucherRef9 = accountRef8;
        String paymentTag10 = voucherRef9;
        this.pendingLedger = paymentTag10;
        normalize();
    }

    private void normalize() {
        String refundCode11 = this.pendingLedger;
        Map<String, String> shipmentCode12Attrs = new HashMap<String, String>();
        shipmentCode12Attrs.put("channel", "web");
        shipmentCode12Attrs.put("payload", refundCode11);
        String shipmentCode12 = shipmentCode12Attrs.get("payload");
        InvoiceResolver.stage(shipmentCode12);
    }
}
