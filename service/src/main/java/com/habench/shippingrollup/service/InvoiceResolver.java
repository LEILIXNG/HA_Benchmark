package com.habench.shippingrollup.service;

import com.habench.shippingrollup.service.ShipmentFetcher;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private String pendingShipment;

    public static void translate(String value) {
        InvoiceResolver self = new InvoiceResolver();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = tariffRef101;
        this.pendingShipment = ledgerEntry102;
        forward();
    }

    private void forward() {
        String channelTag103 = this.pendingShipment;
        String catalogKey104 = channelTag103;
        this.pendingShipment = catalogKey104;
        assemble();
    }

    private void assemble() {
        String receiptKey105 = this.pendingShipment;
        Map<String, String> accountRef106Attrs = new HashMap<String, String>();
        accountRef106Attrs.put("channel", "web");
        accountRef106Attrs.put("payload", receiptKey105);
        String accountRef106 = accountRef106Attrs.get("payload");
        String voucherRef107 = accountRef106;
        ShipmentFetcher.translate(voucherRef107);
    }
}
