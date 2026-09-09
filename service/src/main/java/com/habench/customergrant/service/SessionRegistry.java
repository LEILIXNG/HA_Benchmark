package com.habench.customergrant.service;

import com.habench.customergrant.service.ShipmentGateway;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private static String cachedShipment;

    public static void forward(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        cachedShipment = tariffRef301;
        stage();
    }

    private static void stage() {
        String ledgerEntry302 = cachedShipment;
        String channelTag303 = "ref:" + ledgerEntry302 + ";";
        cachedShipment = channelTag303;
        resolve();
    }

    private static void resolve() {
        String catalogKey304 = cachedShipment;
        String receiptKey305 = "ref:" + catalogKey304 + ";";
        String accountRef306 = receiptKey305;
        cachedShipment = accountRef306;
        refine();
    }

    private static void refine() {
        String voucherRef307 = cachedShipment;
        Map<String, String> paymentTag308Attrs = new HashMap<String, String>();
        paymentTag308Attrs.put("channel", "web");
        paymentTag308Attrs.put("payload", voucherRef307);
        String paymentTag308 = paymentTag308Attrs.get("payload");
        String refundCode309 = paymentTag308;
        ShipmentGateway.reconcile(refundCode309);
    }
}
