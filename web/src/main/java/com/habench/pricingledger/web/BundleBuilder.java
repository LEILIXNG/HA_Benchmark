package com.habench.pricingledger.web;

import com.habench.pricingledger.service.RefundRouter;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private String pendingBundle;
    private static String cachedBundle;

    public static void collect(String value) {
        BundleBuilder self = new BundleBuilder();
        self.translate(value);
    }

    private void translate(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        this.pendingBundle = quoteRef2;
        normalize();
    }

    private void normalize() {
        String tariffRef3 = this.pendingBundle;
        String ledgerEntry4 = tariffRef3;
        this.pendingBundle = ledgerEntry4;
        compose();
    }

    private void compose() {
        String channelTag5 = this.pendingBundle;
        Map<String, String> catalogKey6Attrs = new HashMap<String, String>();
        catalogKey6Attrs.put("channel", "web");
        catalogKey6Attrs.put("payload", channelTag5);
        String catalogKey6 = catalogKey6Attrs.get("payload");
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        this.pendingBundle = receiptKey7;
        dispatch();
    }

    private void dispatch() {
        String accountRef8 = this.pendingBundle;
        Map<String, String> voucherRef9Attrs = new HashMap<String, String>();
        voucherRef9Attrs.put("channel", "web");
        voucherRef9Attrs.put("payload", accountRef8);
        String voucherRef9 = voucherRef9Attrs.get("payload");
        cachedBundle = voucherRef9;
        attach();
    }

    private void attach() {
        String paymentTag10 = cachedBundle;
        Map<String, String> refundCode11Attrs = new HashMap<String, String>();
        refundCode11Attrs.put("channel", "web");
        refundCode11Attrs.put("payload", paymentTag10);
        String refundCode11 = refundCode11Attrs.get("payload");
        String shipmentCode12 = "ref:" + refundCode11 + ";";
        RefundRouter.route(shipmentCode12);
    }
}
