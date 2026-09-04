package com.habench.vendordraft.service;

import com.habench.vendordraft.service.RefundResolver;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private String pendingManifest;
    private static String cachedManifest;

    public static void register(String value) {
        VoucherFacade self = new VoucherFacade();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = orderRef101;
        cachedManifest = quoteRef102;
        publish();
    }

    private void publish() {
        String tariffRef103 = cachedManifest;
        String ledgerEntry104 = tariffRef103;
        String channelTag105 = ledgerEntry104;
        cachedManifest = channelTag105;
        prepare();
    }

    private void prepare() {
        String catalogKey106 = cachedManifest;
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("payload", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("payload");
        this.pendingManifest = receiptKey107;
        compose();
    }

    private void compose() {
        String accountRef108 = this.pendingManifest;
        Map<String, String> voucherRef109Attrs = new HashMap<String, String>();
        voucherRef109Attrs.put("channel", "web");
        voucherRef109Attrs.put("payload", accountRef108);
        String voucherRef109 = voucherRef109Attrs.get("payload");
        this.pendingManifest = voucherRef109;
        translate();
    }

    private void translate() {
        String paymentTag110 = this.pendingManifest;
        String refundCode111 = "ref:" + paymentTag110 + ";";
        String shipmentCode112 = "ref:" + refundCode111 + ";";
        RefundResolver.reconcile(shipmentCode112);
    }
}
