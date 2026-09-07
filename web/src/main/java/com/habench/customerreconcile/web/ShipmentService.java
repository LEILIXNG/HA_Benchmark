package com.habench.customerreconcile.web;

import com.habench.customerreconcile.service.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {
    private String pendingShipment;
    private static String cachedShipment;

    public static void publish(String value) {
        ShipmentService self = new ShipmentService();
        self.collect(value);
    }

    private void collect(String value) {
        String paymentTag1 = "ref:" + value + ";";
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        this.pendingShipment = refundCode2;
        normalize();
    }

    private void normalize() {
        String shipmentCode3 = this.pendingShipment;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        this.pendingShipment = manifestKey4;
        assemble();
    }

    private void assemble() {
        String invoiceKey5 = this.pendingShipment;
        String batchTag6 = "ref:" + invoiceKey5 + ";";
        this.pendingShipment = batchTag6;
        stage();
    }

    private void stage() {
        String orderRef7 = this.pendingShipment;
        String quoteRef8 = orderRef7;
        String tariffRef9 = quoteRef8;
        cachedShipment = tariffRef9;
        submit();
    }

    private void submit() {
        String ledgerEntry10 = cachedShipment;
        String channelTag11 = ledgerEntry10;
        String catalogKey12 = "ref:" + channelTag11 + ";";
        this.pendingShipment = catalogKey12;
        translate();
    }

    private void translate() {
        String receiptKey13 = this.pendingShipment;
        Map<String, String> accountRef14Attrs = new HashMap<String, String>();
        accountRef14Attrs.put("channel", "web");
        accountRef14Attrs.put("payload", receiptKey13);
        String accountRef14 = accountRef14Attrs.get("payload");
        this.pendingShipment = accountRef14;
        compose();
    }

    private void compose() {
        String voucherRef15 = this.pendingShipment;
        String paymentTag16 = voucherRef15;
        ManifestRouter.compose(paymentTag16);
    }
}
