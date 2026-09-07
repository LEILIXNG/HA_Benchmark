package com.habench.reportdigest.service;

import com.habench.reportdigest.service.ChannelEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private String pendingRefund;
    private static String cachedRefund;

    public static void stage(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.submit(value);
    }

    private void submit(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        this.pendingRefund = paymentTag102;
        route();
    }

    private void route() {
        String refundCode103 = this.pendingRefund;
        String shipmentCode104 = "ref:" + refundCode103 + ";";
        Map<String, String> manifestKey105Attrs = new HashMap<String, String>();
        manifestKey105Attrs.put("channel", "web");
        manifestKey105Attrs.put("payload", shipmentCode104);
        String manifestKey105 = manifestKey105Attrs.get("payload");
        this.pendingRefund = manifestKey105;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey106 = this.pendingRefund;
        String batchTag107 = invoiceKey106;
        String orderRef108 = batchTag107;
        cachedRefund = orderRef108;
        expand();
    }

    private void expand() {
        String quoteRef109 = cachedRefund;
        Map<String, String> tariffRef110Attrs = new HashMap<String, String>();
        tariffRef110Attrs.put("channel", "web");
        tariffRef110Attrs.put("payload", quoteRef109);
        String tariffRef110 = tariffRef110Attrs.get("payload");
        String ledgerEntry111 = "ref:" + tariffRef110 + ";";
        cachedRefund = ledgerEntry111;
        translate();
    }

    private void translate() {
        String channelTag112 = cachedRefund;
        String catalogKey113 = "ref:" + channelTag112 + ";";
        cachedRefund = catalogKey113;
        normalize();
    }

    private void normalize() {
        String receiptKey114 = cachedRefund;
        String accountRef115 = "ref:" + receiptKey114 + ";";
        ChannelEnricher.dispatch(accountRef115);
    }
}
