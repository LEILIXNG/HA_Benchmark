package com.habench.catalogbind.web;

import com.habench.catalogbind.service.RefundResolver;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {
    private String pendingTariff;
    private static String cachedTariff;

    public static void forward(String value) {
        PaymentAssembler self = new PaymentAssembler();
        self.prepare(value);
    }

    private void prepare(String value) {
        String receiptKey1 = "ref:" + value + ";";
        this.pendingTariff = receiptKey1;
        publish();
    }

    private void publish() {
        String accountRef2 = this.pendingTariff;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        this.pendingTariff = voucherRef3;
        compose();
    }

    private void compose() {
        String paymentTag4 = this.pendingTariff;
        String refundCode5 = paymentTag4;
        this.pendingTariff = refundCode5;
        expand();
    }

    private void expand() {
        String shipmentCode6 = this.pendingTariff;
        String manifestKey7 = shipmentCode6;
        Map<String, String> invoiceKey8Attrs = new HashMap<String, String>();
        invoiceKey8Attrs.put("channel", "web");
        invoiceKey8Attrs.put("payload", manifestKey7);
        String invoiceKey8 = invoiceKey8Attrs.get("payload");
        cachedTariff = invoiceKey8;
        translate();
    }

    private void translate() {
        String batchTag9 = cachedTariff;
        String orderRef10 = batchTag9;
        String quoteRef11 = orderRef10;
        this.pendingTariff = quoteRef11;
        enrich();
    }

    private void enrich() {
        String tariffRef12 = this.pendingTariff;
        Map<String, String> ledgerEntry13Attrs = new HashMap<String, String>();
        ledgerEntry13Attrs.put("channel", "web");
        ledgerEntry13Attrs.put("payload", tariffRef12);
        String ledgerEntry13 = ledgerEntry13Attrs.get("payload");
        String channelTag14 = "ref:" + ledgerEntry13 + ";";
        RefundResolver.expand(channelTag14);
    }
}
