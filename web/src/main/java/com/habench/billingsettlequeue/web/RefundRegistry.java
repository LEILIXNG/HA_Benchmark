package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.service.RefundFacade;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private String pendingTariff;
    private static String cachedTariff;

    public static void collect(String value) {
        RefundRegistry self = new RefundRegistry();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        this.pendingTariff = quoteRef1;
        resolve();
    }

    private void resolve() {
        String tariffRef2 = this.pendingTariff;
        String ledgerEntry3 = "ref:" + tariffRef2 + ";";
        cachedTariff = ledgerEntry3;
        assemble();
    }

    private void assemble() {
        String channelTag4 = cachedTariff;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        this.pendingTariff = catalogKey5;
        refine();
    }

    private void refine() {
        String receiptKey6 = this.pendingTariff;
        Map<String, String> accountRef7Attrs = new HashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("payload", receiptKey6);
        String accountRef7 = accountRef7Attrs.get("payload");
        this.pendingTariff = accountRef7;
        forward();
    }

    private void forward() {
        String voucherRef8 = this.pendingTariff;
        String paymentTag9 = "ref:" + voucherRef8 + ";";
        Map<String, String> refundCode10Attrs = new HashMap<String, String>();
        refundCode10Attrs.put("channel", "web");
        refundCode10Attrs.put("payload", paymentTag9);
        String refundCode10 = refundCode10Attrs.get("payload");
        RefundFacade.resolve(refundCode10);
    }
}
