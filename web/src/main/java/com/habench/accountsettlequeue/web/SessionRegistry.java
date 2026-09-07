package com.habench.accountsettlequeue.web;

import com.habench.accountsettlequeue.web.VoucherAssembler;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingManifest;
    private static String cachedManifest;

    public static void dispatch(String value) {
        SessionRegistry self = new SessionRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String receiptKey1 = value;
        cachedManifest = receiptKey1;
        assemble();
    }

    private void assemble() {
        String accountRef2 = cachedManifest;
        String voucherRef3 = "ref:" + accountRef2 + ";";
        this.pendingManifest = voucherRef3;
        refine();
    }

    private void refine() {
        String paymentTag4 = this.pendingManifest;
        Map<String, String> refundCode5Attrs = new HashMap<String, String>();
        refundCode5Attrs.put("channel", "web");
        refundCode5Attrs.put("payload", paymentTag4);
        String refundCode5 = refundCode5Attrs.get("payload");
        Map<String, String> shipmentCode6Attrs = new HashMap<String, String>();
        shipmentCode6Attrs.put("channel", "web");
        shipmentCode6Attrs.put("payload", refundCode5);
        String shipmentCode6 = shipmentCode6Attrs.get("payload");
        cachedManifest = shipmentCode6;
        collect();
    }

    private void collect() {
        String manifestKey7 = cachedManifest;
        String invoiceKey8 = "ref:" + manifestKey7 + ";";
        Map<String, String> batchTag9Attrs = new HashMap<String, String>();
        batchTag9Attrs.put("channel", "web");
        batchTag9Attrs.put("payload", invoiceKey8);
        String batchTag9 = batchTag9Attrs.get("payload");
        this.pendingManifest = batchTag9;
        publish();
    }

    private void publish() {
        String orderRef10 = this.pendingManifest;
        String quoteRef11 = orderRef10;
        String tariffRef12 = quoteRef11;
        VoucherAssembler.assemble(tariffRef12);
    }
}
