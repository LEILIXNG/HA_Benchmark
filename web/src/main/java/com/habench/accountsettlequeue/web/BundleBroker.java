package com.habench.accountsettlequeue.web;

import com.habench.accountsettlequeue.service.ManifestFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {
    private static String cachedRefund;

    public static void translate(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        cachedRefund = voucherRef2;
        collect();
    }

    private static void collect() {
        String paymentTag3 = cachedRefund;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        String shipmentCode5 = "ref:" + refundCode4 + ";";
        cachedRefund = shipmentCode5;
        route();
    }

    private static void route() {
        String manifestKey6 = cachedRefund;
        String invoiceKey7 = manifestKey6;
        String batchTag8 = invoiceKey7;
        ManifestFacade.forward(batchTag8);
    }
}
