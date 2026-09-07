package com.habench.reportnotice.web;

import com.habench.reportnotice.service.SessionCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void normalize(String value) {
        ChannelRouter self = new ChannelRouter();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        cachedCatalog = catalogKey2;
        publish();
    }

    private void publish() {
        String receiptKey3 = cachedCatalog;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        String voucherRef5 = "ref:" + accountRef4 + ";";
        this.pendingCatalog = voucherRef5;
        resolve();
    }

    private void resolve() {
        String paymentTag6 = this.pendingCatalog;
        Map<String, String> refundCode7Attrs = new HashMap<String, String>();
        refundCode7Attrs.put("channel", "web");
        refundCode7Attrs.put("payload", paymentTag6);
        String refundCode7 = refundCode7Attrs.get("payload");
        this.pendingCatalog = refundCode7;
        translate();
    }

    private void translate() {
        String shipmentCode8 = this.pendingCatalog;
        String manifestKey9 = shipmentCode8;
        String invoiceKey10 = manifestKey9;
        cachedCatalog = invoiceKey10;
        dispatch();
    }

    private void dispatch() {
        String batchTag11 = cachedCatalog;
        Map<String, String> orderRef12Attrs = new HashMap<String, String>();
        orderRef12Attrs.put("channel", "web");
        orderRef12Attrs.put("payload", batchTag11);
        String orderRef12 = orderRef12Attrs.get("payload");
        this.pendingCatalog = orderRef12;
        route();
    }

    private void route() {
        String quoteRef13 = this.pendingCatalog;
        String tariffRef14 = quoteRef13;
        this.pendingCatalog = tariffRef14;
        refine();
    }

    private void refine() {
        String ledgerEntry15 = this.pendingCatalog;
        String channelTag16 = "ref:" + ledgerEntry15 + ";";
        SessionCoordinator.reconcile(channelTag16);
    }
}
