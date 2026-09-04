package com.habench.accountposting.service;

import com.habench.accountposting.service.TariffExecutor;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private static String cachedTariff;

    public static void expand(String value) {
        String accountRef201 = value;
        cachedTariff = accountRef201;
        stage();
    }

    private static void stage() {
        String voucherRef202 = cachedTariff;
        Map<String, String> paymentTag203Attrs = new HashMap<String, String>();
        paymentTag203Attrs.put("channel", "web");
        paymentTag203Attrs.put("payload", voucherRef202);
        String paymentTag203 = paymentTag203Attrs.get("payload");
        String refundCode204 = "ref:" + paymentTag203 + ";";
        cachedTariff = refundCode204;
        refine();
    }

    private static void refine() {
        String shipmentCode205 = cachedTariff;
        String manifestKey206 = shipmentCode205;
        TariffExecutor.refine(manifestKey206);
    }
}
