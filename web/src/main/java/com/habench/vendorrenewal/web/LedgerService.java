package com.habench.vendorrenewal.web;

import com.habench.vendorrenewal.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {
    private String pendingQuote;
    private static String cachedQuote;

    public static void forward(String value) {
        LedgerService self = new LedgerService();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = "ref:" + accountRef1 + ";";
        cachedQuote = voucherRef2;
        reconcile();
    }

    private void reconcile() {
        String paymentTag3 = cachedQuote;
        String refundCode4 = "ref:" + paymentTag3 + ";";
        Map<String, String> shipmentCode5Attrs = new HashMap<String, String>();
        shipmentCode5Attrs.put("channel", "web");
        shipmentCode5Attrs.put("payload", refundCode4);
        String shipmentCode5 = shipmentCode5Attrs.get("payload");
        this.pendingQuote = shipmentCode5;
        prepare();
    }

    private void prepare() {
        String manifestKey6 = this.pendingQuote;
        String invoiceKey7 = "ref:" + manifestKey6 + ";";
        String batchTag8 = "ref:" + invoiceKey7 + ";";
        cachedQuote = batchTag8;
        stage();
    }

    private void stage() {
        String orderRef9 = cachedQuote;
        Map<String, String> quoteRef10Attrs = new HashMap<String, String>();
        quoteRef10Attrs.put("channel", "web");
        quoteRef10Attrs.put("payload", orderRef9);
        String quoteRef10 = quoteRef10Attrs.get("payload");
        Map<String, String> tariffRef11Attrs = new HashMap<String, String>();
        tariffRef11Attrs.put("channel", "web");
        tariffRef11Attrs.put("payload", quoteRef10);
        String tariffRef11 = tariffRef11Attrs.get("payload");
        cachedQuote = tariffRef11;
        assemble();
    }

    private void assemble() {
        String ledgerEntry12 = cachedQuote;
        String channelTag13 = ledgerEntry12;
        Map<String, String> catalogKey14Attrs = new HashMap<String, String>();
        catalogKey14Attrs.put("channel", "web");
        catalogKey14Attrs.put("payload", channelTag13);
        String catalogKey14 = catalogKey14Attrs.get("payload");
        this.pendingQuote = catalogKey14;
        enrich();
    }

    private void enrich() {
        String receiptKey15 = this.pendingQuote;
        String accountRef16 = "ref:" + receiptKey15 + ";";
        this.pendingQuote = accountRef16;
        register();
    }

    private void register() {
        String voucherRef17 = this.pendingQuote;
        Map<String, String> paymentTag18Attrs = new HashMap<String, String>();
        paymentTag18Attrs.put("channel", "web");
        paymentTag18Attrs.put("payload", voucherRef17);
        String paymentTag18 = paymentTag18Attrs.get("payload");
        String refundCode19 = "ref:" + paymentTag18 + ";";
        ShipmentBuilder.normalize(refundCode19);
    }
}
