package com.habench.reportnotice.web;

import com.habench.reportnotice.service.SessionCollector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {
    private String pendingTariff;
    private static String cachedTariff;

    public static void dispatch(String value) {
        ManifestRegistry self = new ManifestRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        String refundCode1 = value;
        this.pendingTariff = refundCode1;
        assemble();
    }

    private void assemble() {
        String shipmentCode2 = this.pendingTariff;
        String manifestKey3 = "ref:" + shipmentCode2 + ";";
        cachedTariff = manifestKey3;
        normalize();
    }

    private void normalize() {
        String invoiceKey4 = cachedTariff;
        String batchTag5 = invoiceKey4;
        String orderRef6 = batchTag5;
        cachedTariff = orderRef6;
        compose();
    }

    private void compose() {
        String quoteRef7 = cachedTariff;
        Map<String, String> tariffRef8Attrs = new HashMap<String, String>();
        tariffRef8Attrs.put("channel", "web");
        tariffRef8Attrs.put("payload", quoteRef7);
        String tariffRef8 = tariffRef8Attrs.get("payload");
        SessionCollector.collect(tariffRef8);
    }
}
