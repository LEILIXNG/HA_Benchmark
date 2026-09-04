package com.habench.vendoradjust.service;

import com.habench.vendoradjust.service.ShipmentRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {
    private String pendingShipment;

    public static void compose(String value) {
        RefundComposer self = new RefundComposer();
        self.attach(value);
    }

    private void attach(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingShipment = channelTag201;
        translate();
    }

    private void translate() {
        String catalogKey202 = this.pendingShipment;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        String accountRef204 = receiptKey203;
        ShipmentRepository.prepare(accountRef204);
    }
}
