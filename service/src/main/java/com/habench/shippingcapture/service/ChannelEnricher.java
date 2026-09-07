package com.habench.shippingcapture.service;

import com.habench.shippingcapture.service.TariffComposer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelEnricher {
    private String pendingChannel;
    private static String cachedChannel;

    public static void prepare(String value) {
        ChannelEnricher self = new ChannelEnricher();
        self.route(value);
    }

    private void route(String value) {
        String accountRef101 = "ref:" + value + ";";
        this.pendingChannel = accountRef101;
        compose();
    }

    private void compose() {
        String voucherRef102 = this.pendingChannel;
        String paymentTag103 = voucherRef102;
        cachedChannel = paymentTag103;
        resolve();
    }

    private void resolve() {
        String refundCode104 = cachedChannel;
        String shipmentCode105 = "ref:" + refundCode104 + ";";
        Map<String, String> manifestKey106Attrs = new HashMap<String, String>();
        manifestKey106Attrs.put("channel", "web");
        manifestKey106Attrs.put("payload", shipmentCode105);
        String manifestKey106 = manifestKey106Attrs.get("payload");
        TariffComposer.resolve(manifestKey106);
    }
}
