package com.habench.billingcapture.service;

import com.habench.billingcapture.service.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void stage(String value) {
        ChannelTranslator self = new ChannelTranslator();
        self.resolve(value);
    }

    private void resolve(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingInvoice = channelTag201;
        merge();
    }

    private void merge() {
        String catalogKey202 = this.pendingInvoice;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        String accountRef204 = "ref:" + receiptKey203 + ";";
        this.pendingInvoice = accountRef204;
        forward();
    }

    private void forward() {
        String voucherRef205 = this.pendingInvoice;
        Map<String, String> paymentTag206Attrs = new HashMap<String, String>();
        paymentTag206Attrs.put("channel", "web");
        paymentTag206Attrs.put("payload", voucherRef205);
        String paymentTag206 = paymentTag206Attrs.get("payload");
        Map<String, String> refundCode207Attrs = new HashMap<String, String>();
        refundCode207Attrs.put("channel", "web");
        refundCode207Attrs.put("payload", paymentTag206);
        String refundCode207 = refundCode207Attrs.get("payload");
        cachedInvoice = refundCode207;
        prepare();
    }

    private void prepare() {
        String shipmentCode208 = cachedInvoice;
        Map<String, String> manifestKey209Attrs = new HashMap<String, String>();
        manifestKey209Attrs.put("channel", "web");
        manifestKey209Attrs.put("payload", shipmentCode208);
        String manifestKey209 = manifestKey209Attrs.get("payload");
        String invoiceKey210 = "ref:" + manifestKey209 + ";";
        InvoiceRepository.stage(invoiceKey210);
    }
}
