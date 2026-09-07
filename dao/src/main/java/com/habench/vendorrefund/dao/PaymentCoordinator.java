package com.habench.vendorrefund.dao;

import com.habench.vendorrefund.dao.ShipmentRepository;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCoordinator {
    private String pendingShipment;
    private static String cachedShipment;

    public static void route(String value) {
        PaymentCoordinator self = new PaymentCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        String accountRef202 = receiptKey201;
        cachedShipment = accountRef202;
        forward();
    }

    private void forward() {
        String voucherRef203 = cachedShipment;
        String paymentTag204 = voucherRef203;
        String refundCode205 = paymentTag204;
        this.pendingShipment = refundCode205;
        merge();
    }

    private void merge() {
        String shipmentCode206 = this.pendingShipment;
        String manifestKey207 = shipmentCode206;
        cachedShipment = manifestKey207;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey208 = cachedShipment;
        String batchTag209 = "ref:" + invoiceKey208 + ";";
        String orderRef210 = batchTag209;
        this.pendingShipment = orderRef210;
        expand();
    }

    private void expand() {
        String quoteRef211 = this.pendingShipment;
        String tariffRef212 = "ref:" + quoteRef211 + ";";
        ShipmentRepository.merge(tariffRef212);
    }
}
