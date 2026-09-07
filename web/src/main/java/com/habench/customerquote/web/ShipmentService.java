package com.habench.customerquote.web;

import com.habench.customerquote.service.ReceiptCollector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {
    private String pendingAccount;
    private static String cachedAccount;

    public static void route(String value) {
        ShipmentService self = new ShipmentService();
        self.publish(value);
    }

    private void publish(String value) {
        String receiptKey101 = "ref:" + value + ";";
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        cachedAccount = accountRef102;
        reconcile();
    }

    private void reconcile() {
        String voucherRef103 = cachedAccount;
        String paymentTag104 = voucherRef103;
        Map<String, String> refundCode105Attrs = new HashMap<String, String>();
        refundCode105Attrs.put("channel", "web");
        refundCode105Attrs.put("payload", paymentTag104);
        String refundCode105 = refundCode105Attrs.get("payload");
        this.pendingAccount = refundCode105;
        stage();
    }

    private void stage() {
        String shipmentCode106 = this.pendingAccount;
        String manifestKey107 = shipmentCode106;
        Map<String, String> invoiceKey108Attrs = new HashMap<String, String>();
        invoiceKey108Attrs.put("channel", "web");
        invoiceKey108Attrs.put("payload", manifestKey107);
        String invoiceKey108 = invoiceKey108Attrs.get("payload");
        ReceiptCollector.normalize(invoiceKey108);
    }
}
