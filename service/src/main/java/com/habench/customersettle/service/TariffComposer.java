package com.habench.customersettle.service;

import com.habench.customersettle.dao.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffComposer {
    private String pendingShipment;

    public static void forward(String value) {
        TariffComposer self = new TariffComposer();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        this.pendingShipment = manifestKey201;
        prepare();
    }

    private void prepare() {
        String invoiceKey202 = this.pendingShipment;
        String batchTag203 = "ref:" + invoiceKey202 + ";";
        String orderRef204 = "ref:" + batchTag203 + ";";
        RefundComposer.attach(orderRef204);
    }
}
