package com.habench.pricingquote.web;

import com.habench.pricingquote.service.BundleFacade;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {
    private String pendingOrder;
    private static String cachedOrder;

    public static void enrich(String value) {
        InvoiceRegistry self = new InvoiceRegistry();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        cachedOrder = receiptKey2;
        prepare();
    }

    private void prepare() {
        String accountRef3 = cachedOrder;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        Map<String, String> paymentTag5Attrs = new HashMap<String, String>();
        paymentTag5Attrs.put("channel", "web");
        paymentTag5Attrs.put("payload", voucherRef4);
        String paymentTag5 = paymentTag5Attrs.get("payload");
        this.pendingOrder = paymentTag5;
        assemble();
    }

    private void assemble() {
        String refundCode6 = this.pendingOrder;
        String shipmentCode7 = "ref:" + refundCode6 + ";";
        String manifestKey8 = "ref:" + shipmentCode7 + ";";
        cachedOrder = manifestKey8;
        register();
    }

    private void register() {
        String invoiceKey9 = cachedOrder;
        Map<String, String> batchTag10Attrs = new HashMap<String, String>();
        batchTag10Attrs.put("channel", "web");
        batchTag10Attrs.put("payload", invoiceKey9);
        String batchTag10 = batchTag10Attrs.get("payload");
        Map<String, String> orderRef11Attrs = new HashMap<String, String>();
        orderRef11Attrs.put("channel", "web");
        orderRef11Attrs.put("payload", batchTag10);
        String orderRef11 = orderRef11Attrs.get("payload");
        cachedOrder = orderRef11;
        dispatch();
    }

    private void dispatch() {
        String quoteRef12 = cachedOrder;
        String tariffRef13 = quoteRef12;
        Map<String, String> ledgerEntry14Attrs = new HashMap<String, String>();
        ledgerEntry14Attrs.put("channel", "web");
        ledgerEntry14Attrs.put("payload", tariffRef13);
        String ledgerEntry14 = ledgerEntry14Attrs.get("payload");
        this.pendingOrder = ledgerEntry14;
        refine();
    }

    private void refine() {
        String channelTag15 = this.pendingOrder;
        String catalogKey16 = "ref:" + channelTag15 + ";";
        this.pendingOrder = catalogKey16;
        reconcile();
    }

    private void reconcile() {
        String receiptKey17 = this.pendingOrder;
        Map<String, String> accountRef18Attrs = new HashMap<String, String>();
        accountRef18Attrs.put("channel", "web");
        accountRef18Attrs.put("payload", receiptKey17);
        String accountRef18 = accountRef18Attrs.get("payload");
        String voucherRef19 = "ref:" + accountRef18 + ";";
        BundleFacade.compose(voucherRef19);
    }
}
