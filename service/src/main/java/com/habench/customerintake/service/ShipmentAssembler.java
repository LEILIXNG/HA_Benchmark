package com.habench.customerintake.service;

import com.habench.customerintake.service.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAssembler {
    private String pendingTariff;

    public static void publish(String value) {
        ShipmentAssembler self = new ShipmentAssembler();
        self.normalize(value);
    }

    private void normalize(String value) {
        String quoteRef101 = "ref:" + value + ";";
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        this.pendingTariff = tariffRef102;
        register();
    }

    private void register() {
        String ledgerEntry103 = this.pendingTariff;
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        TariffRepository.forward(channelTag104);
    }
}
