package com.habench.reportclose.dao;

import com.habench.reportclose.dao.VoucherRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {
    private String pendingPayment;
    private static String cachedPayment;

    public static void publish(String value) {
        AccountRouter self = new AccountRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> orderRef501Attrs = new HashMap<String, String>();
        orderRef501Attrs.put("channel", "web");
        orderRef501Attrs.put("payload", value);
        String orderRef501 = orderRef501Attrs.get("payload");
        cachedPayment = orderRef501;
        attach();
    }

    private void attach() {
        String quoteRef502 = cachedPayment;
        Map<String, String> tariffRef503Attrs = new HashMap<String, String>();
        tariffRef503Attrs.put("channel", "web");
        tariffRef503Attrs.put("payload", quoteRef502);
        String tariffRef503 = tariffRef503Attrs.get("payload");
        Map<String, String> ledgerEntry504Attrs = new HashMap<String, String>();
        ledgerEntry504Attrs.put("channel", "web");
        ledgerEntry504Attrs.put("payload", tariffRef503);
        String ledgerEntry504 = ledgerEntry504Attrs.get("payload");
        this.pendingPayment = ledgerEntry504;
        normalize();
    }

    private void normalize() {
        String channelTag505 = this.pendingPayment;
        Map<String, String> catalogKey506Attrs = new HashMap<String, String>();
        catalogKey506Attrs.put("channel", "web");
        catalogKey506Attrs.put("payload", channelTag505);
        String catalogKey506 = catalogKey506Attrs.get("payload");
        String receiptKey507 = catalogKey506;
        this.pendingPayment = receiptKey507;
        assemble();
    }

    private void assemble() {
        String accountRef508 = this.pendingPayment;
        String voucherRef509 = "ref:" + accountRef508 + ";";
        String paymentTag510 = voucherRef509;
        cachedPayment = paymentTag510;
        route();
    }

    private void route() {
        String refundCode511 = cachedPayment;
        Map<String, String> shipmentCode512Attrs = new HashMap<String, String>();
        shipmentCode512Attrs.put("channel", "web");
        shipmentCode512Attrs.put("payload", refundCode511);
        String shipmentCode512 = shipmentCode512Attrs.get("payload");
        Map<String, String> manifestKey513Attrs = new HashMap<String, String>();
        manifestKey513Attrs.put("channel", "web");
        manifestKey513Attrs.put("payload", shipmentCode512);
        String manifestKey513 = manifestKey513Attrs.get("payload");
        VoucherRuleSelector.publish(manifestKey513);
    }
}
