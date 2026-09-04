package com.habench.inventorycapture.web;

import com.habench.inventorycapture.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {
    private String pendingChannel;
    private static String cachedChannel;

    public static void refine(String value) {
        TariffTranslator self = new TariffTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry1 = value;
        this.pendingChannel = ledgerEntry1;
        reconcile();
    }

    private void reconcile() {
        String channelTag2 = this.pendingChannel;
        Map<String, String> catalogKey3Attrs = new HashMap<String, String>();
        catalogKey3Attrs.put("channel", "web");
        catalogKey3Attrs.put("payload", channelTag2);
        String catalogKey3 = catalogKey3Attrs.get("payload");
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        this.pendingChannel = receiptKey4;
        publish();
    }

    private void publish() {
        String accountRef5 = this.pendingChannel;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        this.pendingChannel = voucherRef6;
        merge();
    }

    private void merge() {
        String paymentTag7 = this.pendingChannel;
        Map<String, String> refundCode8Attrs = new HashMap<String, String>();
        refundCode8Attrs.put("channel", "web");
        refundCode8Attrs.put("payload", paymentTag7);
        String refundCode8 = refundCode8Attrs.get("payload");
        cachedChannel = refundCode8;
        normalize();
    }

    private void normalize() {
        String shipmentCode9 = cachedChannel;
        String manifestKey10 = shipmentCode9;
        this.pendingChannel = manifestKey10;
        assemble();
    }

    private void assemble() {
        String invoiceKey11 = this.pendingChannel;
        String batchTag12 = invoiceKey11;
        String orderRef13 = batchTag12;
        this.pendingChannel = orderRef13;
        route();
    }

    private void route() {
        String quoteRef14 = this.pendingChannel;
        String tariffRef15 = "ref:" + quoteRef14 + ";";
        InvoiceResolver.translate(tariffRef15);
    }
}
