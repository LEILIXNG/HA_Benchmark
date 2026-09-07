package com.habench.paymentintake.web;

import com.habench.paymentintake.web.TariffRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountComposer {
    private String pendingPayment;
    private static String cachedPayment;

    public static void compose(String value) {
        AccountComposer self = new AccountComposer();
        self.expand(value);
    }

    private void expand(String value) {
        String channelTag1 = value;
        cachedPayment = channelTag1;
        collect();
    }

    private void collect() {
        String catalogKey2 = cachedPayment;
        String receiptKey3 = "ref:" + catalogKey2 + ";";
        this.pendingPayment = receiptKey3;
        assemble();
    }

    private void assemble() {
        String accountRef4 = this.pendingPayment;
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        Map<String, String> paymentTag6Attrs = new HashMap<String, String>();
        paymentTag6Attrs.put("channel", "web");
        paymentTag6Attrs.put("payload", voucherRef5);
        String paymentTag6 = paymentTag6Attrs.get("payload");
        cachedPayment = paymentTag6;
        register();
    }

    private void register() {
        String refundCode7 = cachedPayment;
        String shipmentCode8 = "ref:" + refundCode7 + ";";
        Map<String, String> manifestKey9Attrs = new HashMap<String, String>();
        manifestKey9Attrs.put("channel", "web");
        manifestKey9Attrs.put("payload", shipmentCode8);
        String manifestKey9 = manifestKey9Attrs.get("payload");
        this.pendingPayment = manifestKey9;
        normalize();
    }

    private void normalize() {
        String invoiceKey10 = this.pendingPayment;
        String batchTag11 = invoiceKey10;
        String orderRef12 = batchTag11;
        TariffRouter.enrich(orderRef12);
    }
}
