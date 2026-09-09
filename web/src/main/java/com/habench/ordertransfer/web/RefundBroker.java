package com.habench.ordertransfer.web;

import com.habench.ordertransfer.web.AccountRegistry;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingQuote;
    private static String cachedQuote;

    public static void forward(String value) {
        RefundBroker self = new RefundBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = quoteRef1;
        this.pendingQuote = tariffRef2;
        merge();
    }

    private void merge() {
        String ledgerEntry3 = this.pendingQuote;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        String catalogKey5 = channelTag4;
        this.pendingQuote = catalogKey5;
        publish();
    }

    private void publish() {
        String receiptKey6 = this.pendingQuote;
        Map<String, String> accountRef7Attrs = new HashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("payload", receiptKey6);
        String accountRef7 = accountRef7Attrs.get("payload");
        this.pendingQuote = accountRef7;
        translate();
    }

    private void translate() {
        String voucherRef8 = this.pendingQuote;
        String paymentTag9 = "ref:" + voucherRef8 + ";";
        String refundCode10 = "ref:" + paymentTag9 + ";";
        this.pendingQuote = refundCode10;
        register();
    }

    private void register() {
        String shipmentCode11 = this.pendingQuote;
        String manifestKey12 = "ref:" + shipmentCode11 + ";";
        cachedQuote = manifestKey12;
        prepare();
    }

    private void prepare() {
        String invoiceKey13 = cachedQuote;
        Map<String, String> batchTag14Attrs = new HashMap<String, String>();
        batchTag14Attrs.put("channel", "web");
        batchTag14Attrs.put("payload", invoiceKey13);
        String batchTag14 = batchTag14Attrs.get("payload");
        String orderRef15 = batchTag14;
        this.pendingQuote = orderRef15;
        assemble();
    }

    private void assemble() {
        String quoteRef16 = this.pendingQuote;
        Map<String, String> tariffRef17Attrs = new HashMap<String, String>();
        tariffRef17Attrs.put("channel", "web");
        tariffRef17Attrs.put("payload", quoteRef16);
        String tariffRef17 = tariffRef17Attrs.get("payload");
        Map<String, String> ledgerEntry18Attrs = new HashMap<String, String>();
        ledgerEntry18Attrs.put("channel", "web");
        ledgerEntry18Attrs.put("payload", tariffRef17);
        String ledgerEntry18 = ledgerEntry18Attrs.get("payload");
        this.pendingQuote = ledgerEntry18;
        normalize();
    }

    private void normalize() {
        String channelTag19 = this.pendingQuote;
        Map<String, String> catalogKey20Attrs = new HashMap<String, String>();
        catalogKey20Attrs.put("channel", "web");
        catalogKey20Attrs.put("payload", channelTag19);
        String catalogKey20 = catalogKey20Attrs.get("payload");
        Map<String, String> receiptKey21Attrs = new HashMap<String, String>();
        receiptKey21Attrs.put("channel", "web");
        receiptKey21Attrs.put("payload", catalogKey20);
        String receiptKey21 = receiptKey21Attrs.get("payload");
        AccountRegistry.expand(receiptKey21);
    }
}
