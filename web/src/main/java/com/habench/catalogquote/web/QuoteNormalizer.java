package com.habench.catalogquote.web;

import com.habench.catalogquote.service.VoucherAssembler;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private static String cachedTariff;

    public static void register(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = "ref:" + accountRef1 + ";";
        cachedTariff = voucherRef2;
        refine();
    }

    private static void refine() {
        String paymentTag3 = cachedTariff;
        String refundCode4 = paymentTag3;
        Map<String, String> shipmentCode5Attrs = new HashMap<String, String>();
        shipmentCode5Attrs.put("channel", "web");
        shipmentCode5Attrs.put("payload", refundCode4);
        String shipmentCode5 = shipmentCode5Attrs.get("payload");
        VoucherAssembler.expand(shipmentCode5);
    }
}
