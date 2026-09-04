package com.habench.vendorlookup.service;

import com.habench.vendorlookup.dao.AccountTranslator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentFacade {
    private String pendingRefund;
    private static String cachedRefund;

    public static void reconcile(String value) {
        PaymentFacade self = new PaymentFacade();
        self.attach(value);
    }

    private void attach(String value) {
        String tariffRef101 = "ref:" + value + ";";
        String ledgerEntry102 = tariffRef101;
        this.pendingRefund = ledgerEntry102;
        enrich();
    }

    private void enrich() {
        String channelTag103 = this.pendingRefund;
        String catalogKey104 = channelTag103;
        String receiptKey105 = "ref:" + catalogKey104 + ";";
        cachedRefund = receiptKey105;
        normalize();
    }

    private void normalize() {
        String accountRef106 = cachedRefund;
        String voucherRef107 = "ref:" + accountRef106 + ";";
        cachedRefund = voucherRef107;
        forward();
    }

    private void forward() {
        String paymentTag108 = cachedRefund;
        String refundCode109 = paymentTag108;
        this.pendingRefund = refundCode109;
        publish();
    }

    private void publish() {
        String shipmentCode110 = this.pendingRefund;
        String manifestKey111 = shipmentCode110;
        String invoiceKey112 = manifestKey111;
        this.pendingRefund = invoiceKey112;
        prepare();
    }

    private void prepare() {
        String batchTag113 = this.pendingRefund;
        Map<String, String> orderRef114Attrs = new HashMap<String, String>();
        orderRef114Attrs.put("channel", "web");
        orderRef114Attrs.put("payload", batchTag113);
        String orderRef114 = orderRef114Attrs.get("payload");
        Map<String, String> quoteRef115Attrs = new HashMap<String, String>();
        quoteRef115Attrs.put("channel", "web");
        quoteRef115Attrs.put("payload", orderRef114);
        String quoteRef115 = quoteRef115Attrs.get("payload");
        AccountTranslator.route(quoteRef115);
    }
}
