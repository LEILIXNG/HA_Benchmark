package com.habench.fulfilintake.web;

import com.habench.fulfilintake.service.BatchRouter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingSession;
    private static String cachedSession;

    public static void attach(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.publish(value);
    }

    private void publish(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = "ref:" + quoteRef101 + ";";
        this.pendingSession = tariffRef102;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry103 = this.pendingSession;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        String catalogKey105 = channelTag104;
        cachedSession = catalogKey105;
        reconcile();
    }

    private void reconcile() {
        String receiptKey106 = cachedSession;
        String accountRef107 = "ref:" + receiptKey106 + ";";
        this.pendingSession = accountRef107;
        route();
    }

    private void route() {
        String voucherRef108 = this.pendingSession;
        Map<String, String> paymentTag109Attrs = new HashMap<String, String>();
        paymentTag109Attrs.put("channel", "web");
        paymentTag109Attrs.put("payload", voucherRef108);
        String paymentTag109 = paymentTag109Attrs.get("payload");
        cachedSession = paymentTag109;
        merge();
    }

    private void merge() {
        String refundCode110 = cachedSession;
        Map<String, String> shipmentCode111Attrs = new HashMap<String, String>();
        shipmentCode111Attrs.put("channel", "web");
        shipmentCode111Attrs.put("payload", refundCode110);
        String shipmentCode111 = shipmentCode111Attrs.get("payload");
        Map<String, String> manifestKey112Attrs = new HashMap<String, String>();
        manifestKey112Attrs.put("channel", "web");
        manifestKey112Attrs.put("payload", shipmentCode111);
        String manifestKey112 = manifestKey112Attrs.get("payload");
        BatchRouter.assemble(manifestKey112);
    }
}
