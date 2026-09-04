package com.habench.orderimport.dao;

import com.habench.orderimport.dao.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingPayment;
    private static String cachedPayment;

    public static void attach(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        cachedPayment = tariffRef201;
        normalize();
    }

    private void normalize() {
        String ledgerEntry202 = cachedPayment;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        this.pendingPayment = channelTag203;
        collect();
    }

    private void collect() {
        String catalogKey204 = this.pendingPayment;
        String receiptKey205 = catalogKey204;
        String accountRef206 = receiptKey205;
        PaymentRepository.publish(accountRef206);
    }
}
