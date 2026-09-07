package com.habench.vendordigest.service;

import com.habench.vendordigest.service.BatchStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private String pendingTariff;
    private static String cachedTariff;

    public static void enrich(String value) {
        ShipmentBroker self = new ShipmentBroker();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        cachedTariff = accountRef201;
        compose();
    }

    private void compose() {
        String voucherRef202 = cachedTariff;
        String paymentTag203 = voucherRef202;
        this.pendingTariff = paymentTag203;
        attach();
    }

    private void attach() {
        String refundCode204 = this.pendingTariff;
        Map<String, String> shipmentCode205Attrs = new HashMap<String, String>();
        shipmentCode205Attrs.put("channel", "web");
        shipmentCode205Attrs.put("payload", refundCode204);
        String shipmentCode205 = shipmentCode205Attrs.get("payload");
        this.pendingTariff = shipmentCode205;
        prepare();
    }

    private void prepare() {
        String manifestKey206 = this.pendingTariff;
        String invoiceKey207 = manifestKey206;
        Map<String, String> batchTag208Attrs = new HashMap<String, String>();
        batchTag208Attrs.put("channel", "web");
        batchTag208Attrs.put("payload", invoiceKey207);
        String batchTag208 = batchTag208Attrs.get("payload");
        BatchStrategySelector.normalize(batchTag208);
    }
}
