package com.habench.vendorrefund.service;

import com.habench.vendorrefund.service.PaymentPolicy;
import java.util.HashMap;
import java.util.Map;

public final class TariffResolver {
    private String pendingShipment;
    private static String cachedShipment;

    public static void resolve(String value) {
        TariffResolver self = new TariffResolver();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        this.pendingShipment = catalogKey102;
        expand();
    }

    private void expand() {
        String receiptKey103 = this.pendingShipment;
        String accountRef104 = receiptKey103;
        cachedShipment = accountRef104;
        route();
    }

    private void route() {
        String voucherRef105 = cachedShipment;
        String paymentTag106 = voucherRef105;
        String refundCode107 = paymentTag106;
        this.pendingShipment = refundCode107;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode108 = this.pendingShipment;
        String manifestKey109 = "ref:" + shipmentCode108 + ";";
        this.pendingShipment = manifestKey109;
        attach();
    }

    private void attach() {
        String invoiceKey110 = this.pendingShipment;
        Map<String, String> batchTag111Attrs = new HashMap<String, String>();
        batchTag111Attrs.put("channel", "web");
        batchTag111Attrs.put("payload", invoiceKey110);
        String batchTag111 = batchTag111Attrs.get("payload");
        this.pendingShipment = batchTag111;
        compose();
    }

    private void compose() {
        String orderRef112 = this.pendingShipment;
        String quoteRef113 = "ref:" + orderRef112 + ";";
        Map<String, String> tariffRef114Attrs = new HashMap<String, String>();
        tariffRef114Attrs.put("channel", "web");
        tariffRef114Attrs.put("payload", quoteRef113);
        String tariffRef114 = tariffRef114Attrs.get("payload");
        cachedShipment = tariffRef114;
        refine();
    }

    private void refine() {
        String ledgerEntry115 = cachedShipment;
        Map<String, String> channelTag116Attrs = new HashMap<String, String>();
        channelTag116Attrs.put("channel", "web");
        channelTag116Attrs.put("payload", ledgerEntry115);
        String channelTag116 = channelTag116Attrs.get("payload");
        String catalogKey117 = "ref:" + channelTag116 + ";";
        PaymentPolicy.collect(catalogKey117);
    }
}
