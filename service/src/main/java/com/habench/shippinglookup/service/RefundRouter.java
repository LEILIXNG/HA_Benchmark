package com.habench.shippinglookup.service;

import com.habench.shippinglookup.service.RefundService;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {
    private String pendingTariff;
    private static String cachedTariff;

    public static void compose(String value) {
        RefundRouter self = new RefundRouter();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        cachedTariff = manifestKey202;
        publish();
    }

    private void publish() {
        String invoiceKey203 = cachedTariff;
        String batchTag204 = invoiceKey203;
        Map<String, String> orderRef205Attrs = new HashMap<String, String>();
        orderRef205Attrs.put("channel", "web");
        orderRef205Attrs.put("payload", batchTag204);
        String orderRef205 = orderRef205Attrs.get("payload");
        this.pendingTariff = orderRef205;
        expand();
    }

    private void expand() {
        String quoteRef206 = this.pendingTariff;
        String tariffRef207 = quoteRef206;
        this.pendingTariff = tariffRef207;
        route();
    }

    private void route() {
        String ledgerEntry208 = this.pendingTariff;
        String channelTag209 = "ref:" + ledgerEntry208 + ";";
        String catalogKey210 = channelTag209;
        this.pendingTariff = catalogKey210;
        normalize();
    }

    private void normalize() {
        String receiptKey211 = this.pendingTariff;
        Map<String, String> accountRef212Attrs = new HashMap<String, String>();
        accountRef212Attrs.put("channel", "web");
        accountRef212Attrs.put("payload", receiptKey211);
        String accountRef212 = accountRef212Attrs.get("payload");
        String voucherRef213 = "ref:" + accountRef212 + ";";
        cachedTariff = voucherRef213;
        assemble();
    }

    private void assemble() {
        String paymentTag214 = cachedTariff;
        String refundCode215 = "ref:" + paymentTag214 + ";";
        cachedTariff = refundCode215;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode216 = cachedTariff;
        String manifestKey217 = shipmentCode216;
        RefundService.prepare(manifestKey217);
    }
}
