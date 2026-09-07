package com.habench.inventorydigest.service;

import com.habench.inventorydigest.dao.ShipmentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {
    private String pendingAccount;
    private static String cachedAccount;

    public static void refine(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.route(value);
    }

    private void route(String value) {
        String quoteRef101 = value;
        String tariffRef102 = quoteRef101;
        this.pendingAccount = tariffRef102;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry103 = this.pendingAccount;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        cachedAccount = channelTag104;
        enrich();
    }

    private void enrich() {
        String catalogKey105 = cachedAccount;
        String receiptKey106 = catalogKey105;
        String accountRef107 = receiptKey106;
        cachedAccount = accountRef107;
        publish();
    }

    private void publish() {
        String voucherRef108 = cachedAccount;
        Map<String, String> paymentTag109Attrs = new HashMap<String, String>();
        paymentTag109Attrs.put("channel", "web");
        paymentTag109Attrs.put("payload", voucherRef108);
        String paymentTag109 = paymentTag109Attrs.get("payload");
        String refundCode110 = "ref:" + paymentTag109 + ";";
        this.pendingAccount = refundCode110;
        compose();
    }

    private void compose() {
        String shipmentCode111 = this.pendingAccount;
        String manifestKey112 = "ref:" + shipmentCode111 + ";";
        String invoiceKey113 = manifestKey112;
        this.pendingAccount = invoiceKey113;
        reconcile();
    }

    private void reconcile() {
        String batchTag114 = this.pendingAccount;
        Map<String, String> orderRef115Attrs = new HashMap<String, String>();
        orderRef115Attrs.put("channel", "web");
        orderRef115Attrs.put("payload", batchTag114);
        String orderRef115 = orderRef115Attrs.get("payload");
        ShipmentCoordinator.dispatch(orderRef115);
    }
}
