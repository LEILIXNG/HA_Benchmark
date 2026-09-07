package com.habench.reportsync.service;

import com.habench.reportsync.service.ChannelPolicy;

public final class ManifestBroker {
    private String pendingRefund;
    private static String cachedRefund;

    public static void merge(String value) {
        ManifestBroker self = new ManifestBroker();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = channelTag201;
        cachedRefund = catalogKey202;
        forward();
    }

    private void forward() {
        String receiptKey203 = cachedRefund;
        String accountRef204 = receiptKey203;
        String voucherRef205 = "ref:" + accountRef204 + ";";
        cachedRefund = voucherRef205;
        expand();
    }

    private void expand() {
        String paymentTag206 = cachedRefund;
        String refundCode207 = "ref:" + paymentTag206 + ";";
        String shipmentCode208 = "ref:" + refundCode207 + ";";
        this.pendingRefund = shipmentCode208;
        assemble();
    }

    private void assemble() {
        String manifestKey209 = this.pendingRefund;
        String invoiceKey210 = manifestKey209;
        ChannelPolicy.translate(invoiceKey210);
    }
}
