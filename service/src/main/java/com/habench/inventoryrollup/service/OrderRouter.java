package com.habench.inventoryrollup.service;

import com.habench.inventoryrollup.dao.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;

public final class OrderRouter {
    private String pendingAccount;
    private static String cachedAccount;

    public static void merge(String value) {
        OrderRouter self = new OrderRouter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String quoteRef101 = value;
        String tariffRef102 = quoteRef101;
        this.pendingAccount = tariffRef102;
        enrich();
    }

    private void enrich() {
        String ledgerEntry103 = this.pendingAccount;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        cachedAccount = channelTag104;
        compose();
    }

    private void compose() {
        String catalogKey105 = cachedAccount;
        String receiptKey106 = catalogKey105;
        String accountRef107 = receiptKey106;
        cachedAccount = accountRef107;
        translate();
    }

    private void translate() {
        String voucherRef108 = cachedAccount;
        Map<String, String> paymentTag109Attrs = new HashMap<String, String>();
        paymentTag109Attrs.put("channel", "web");
        paymentTag109Attrs.put("payload", voucherRef108);
        String paymentTag109 = paymentTag109Attrs.get("payload");
        String refundCode110 = "ref:" + paymentTag109 + ";";
        this.pendingAccount = refundCode110;
        publish();
    }

    private void publish() {
        String shipmentCode111 = this.pendingAccount;
        String manifestKey112 = "ref:" + shipmentCode111 + ";";
        String invoiceKey113 = manifestKey112;
        this.pendingAccount = invoiceKey113;
        dispatch();
    }

    private void dispatch() {
        String batchTag114 = this.pendingAccount;
        Map<String, String> orderRef115Attrs = new HashMap<String, String>();
        orderRef115Attrs.put("channel", "web");
        orderRef115Attrs.put("payload", batchTag114);
        String orderRef115 = orderRef115Attrs.get("payload");
        QuoteAssembler.route(orderRef115);
    }
}
