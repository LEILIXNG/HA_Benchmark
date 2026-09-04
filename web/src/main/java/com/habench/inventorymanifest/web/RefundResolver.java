package com.habench.inventorymanifest.web;

import com.habench.inventorymanifest.service.ChannelTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundResolver {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void register(String value) {
        RefundResolver self = new RefundResolver();
        self.translate(value);
    }

    private void translate(String value) {
        String receiptKey1 = value;
        cachedCatalog = receiptKey1;
        merge();
    }

    private void merge() {
        String accountRef2 = cachedCatalog;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        cachedCatalog = voucherRef3;
        route();
    }

    private void route() {
        String paymentTag4 = cachedCatalog;
        String refundCode5 = paymentTag4;
        this.pendingCatalog = refundCode5;
        assemble();
    }

    private void assemble() {
        String shipmentCode6 = this.pendingCatalog;
        Map<String, String> manifestKey7Attrs = new HashMap<String, String>();
        manifestKey7Attrs.put("channel", "web");
        manifestKey7Attrs.put("payload", shipmentCode6);
        String manifestKey7 = manifestKey7Attrs.get("payload");
        cachedCatalog = manifestKey7;
        attach();
    }

    private void attach() {
        String invoiceKey8 = cachedCatalog;
        String batchTag9 = invoiceKey8;
        String orderRef10 = batchTag9;
        cachedCatalog = orderRef10;
        forward();
    }

    private void forward() {
        String quoteRef11 = cachedCatalog;
        String tariffRef12 = "ref:" + quoteRef11 + ";";
        ChannelTranslator.forward(tariffRef12);
    }
}
