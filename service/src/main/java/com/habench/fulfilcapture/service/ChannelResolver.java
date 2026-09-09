package com.habench.fulfilcapture.service;

import com.habench.fulfilcapture.service.ManifestFilter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {
    private String pendingTariff;
    private static String cachedTariff;

    public static void forward(String value) {
        ChannelResolver self = new ChannelResolver();
        self.merge(value);
    }

    private void merge(String value) {
        String receiptKey401 = value;
        String accountRef402 = receiptKey401;
        this.pendingTariff = accountRef402;
        assemble();
    }

    private void assemble() {
        String voucherRef403 = this.pendingTariff;
        String paymentTag404 = voucherRef403;
        Map<String, String> refundCode405Attrs = new HashMap<String, String>();
        refundCode405Attrs.put("channel", "web");
        refundCode405Attrs.put("payload", paymentTag404);
        String refundCode405 = refundCode405Attrs.get("payload");
        cachedTariff = refundCode405;
        collect();
    }

    private void collect() {
        String shipmentCode406 = cachedTariff;
        Map<String, String> manifestKey407Attrs = new HashMap<String, String>();
        manifestKey407Attrs.put("channel", "web");
        manifestKey407Attrs.put("payload", shipmentCode406);
        String manifestKey407 = manifestKey407Attrs.get("payload");
        String invoiceKey408 = manifestKey407;
        this.pendingTariff = invoiceKey408;
        refine();
    }

    private void refine() {
        String batchTag409 = this.pendingTariff;
        Map<String, String> orderRef410Attrs = new HashMap<String, String>();
        orderRef410Attrs.put("channel", "web");
        orderRef410Attrs.put("payload", batchTag409);
        String orderRef410 = orderRef410Attrs.get("payload");
        cachedTariff = orderRef410;
        resolve();
    }

    private void resolve() {
        String quoteRef411 = cachedTariff;
        String tariffRef412 = "ref:" + quoteRef411 + ";";
        String ledgerEntry413 = tariffRef412;
        ManifestFilter.submit(ledgerEntry413);
    }
}
