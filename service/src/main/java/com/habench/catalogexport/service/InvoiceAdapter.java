package com.habench.catalogexport.service;

import com.habench.catalogexport.service.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void merge(String value) {
        InvoiceAdapter self = new InvoiceAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        this.pendingShipment = channelTag102;
        forward();
    }

    private void forward() {
        String catalogKey103 = this.pendingShipment;
        String receiptKey104 = catalogKey103;
        this.pendingShipment = receiptKey104;
        collect();
    }

    private void collect() {
        String accountRef105 = this.pendingShipment;
        String voucherRef106 = accountRef105;
        cachedShipment = voucherRef106;
        submit();
    }

    private void submit() {
        String paymentTag107 = cachedShipment;
        Map<String, String> refundCode108Attrs = new HashMap<String, String>();
        refundCode108Attrs.put("channel", "web");
        refundCode108Attrs.put("payload", paymentTag107);
        String refundCode108 = refundCode108Attrs.get("payload");
        String shipmentCode109 = "ref:" + refundCode108 + ";";
        this.pendingShipment = shipmentCode109;
        translate();
    }

    private void translate() {
        String manifestKey110 = this.pendingShipment;
        Map<String, String> invoiceKey111Attrs = new HashMap<String, String>();
        invoiceKey111Attrs.put("channel", "web");
        invoiceKey111Attrs.put("payload", manifestKey110);
        String invoiceKey111 = invoiceKey111Attrs.get("payload");
        cachedShipment = invoiceKey111;
        prepare();
    }

    private void prepare() {
        String batchTag112 = cachedShipment;
        Map<String, String> orderRef113Attrs = new HashMap<String, String>();
        orderRef113Attrs.put("channel", "web");
        orderRef113Attrs.put("payload", batchTag112);
        String orderRef113 = orderRef113Attrs.get("payload");
        Map<String, String> quoteRef114Attrs = new HashMap<String, String>();
        quoteRef114Attrs.put("channel", "web");
        quoteRef114Attrs.put("payload", orderRef113);
        String quoteRef114 = quoteRef114Attrs.get("payload");
        LedgerRuleSelector.resolve(quoteRef114);
    }
}
