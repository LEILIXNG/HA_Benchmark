package com.habench.fulfilsettlequeue.web;

import com.habench.fulfilsettlequeue.service.PaymentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingLedger;
    private static String cachedLedger;

    public static void collect(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        this.pendingLedger = paymentTag2;
        publish();
    }

    private void publish() {
        String refundCode3 = this.pendingLedger;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        Map<String, String> manifestKey5Attrs = new HashMap<String, String>();
        manifestKey5Attrs.put("channel", "web");
        manifestKey5Attrs.put("payload", shipmentCode4);
        String manifestKey5 = manifestKey5Attrs.get("payload");
        this.pendingLedger = manifestKey5;
        translate();
    }

    private void translate() {
        String invoiceKey6 = this.pendingLedger;
        String batchTag7 = invoiceKey6;
        String orderRef8 = batchTag7;
        cachedLedger = orderRef8;
        expand();
    }

    private void expand() {
        String quoteRef9 = cachedLedger;
        Map<String, String> tariffRef10Attrs = new HashMap<String, String>();
        tariffRef10Attrs.put("channel", "web");
        tariffRef10Attrs.put("payload", quoteRef9);
        String tariffRef10 = tariffRef10Attrs.get("payload");
        PaymentRegistry.assemble(tariffRef10);
    }
}
