package com.habench.vendorsettle.web;

import com.habench.vendorsettle.service.TariffBroker;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {
    private String pendingLedger;
    private static String cachedLedger;

    public static void collect(String value) {
        TariffNormalizer self = new TariffNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String receiptKey1 = "ref:" + value + ";";
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        this.pendingLedger = accountRef2;
        assemble();
    }

    private void assemble() {
        String voucherRef3 = this.pendingLedger;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        this.pendingLedger = paymentTag4;
        normalize();
    }

    private void normalize() {
        String refundCode5 = this.pendingLedger;
        String shipmentCode6 = "ref:" + refundCode5 + ";";
        this.pendingLedger = shipmentCode6;
        publish();
    }

    private void publish() {
        String manifestKey7 = this.pendingLedger;
        String invoiceKey8 = manifestKey7;
        String batchTag9 = invoiceKey8;
        cachedLedger = batchTag9;
        enrich();
    }

    private void enrich() {
        String orderRef10 = cachedLedger;
        String quoteRef11 = orderRef10;
        String tariffRef12 = "ref:" + quoteRef11 + ";";
        this.pendingLedger = tariffRef12;
        resolve();
    }

    private void resolve() {
        String ledgerEntry13 = this.pendingLedger;
        Map<String, String> channelTag14Attrs = new HashMap<String, String>();
        channelTag14Attrs.put("channel", "web");
        channelTag14Attrs.put("payload", ledgerEntry13);
        String channelTag14 = channelTag14Attrs.get("payload");
        this.pendingLedger = channelTag14;
        expand();
    }

    private void expand() {
        String catalogKey15 = this.pendingLedger;
        String receiptKey16 = catalogKey15;
        TariffBroker.merge(receiptKey16);
    }
}
