package com.habench.catalogbind.web;

import com.habench.catalogbind.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {
    private String pendingTariff;
    private static String cachedTariff;

    public static void compose(String value) {
        QuoteBroker self = new QuoteBroker();
        self.expand(value);
    }

    private void expand(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        this.pendingTariff = accountRef2;
        prepare();
    }

    private void prepare() {
        String voucherRef3 = this.pendingTariff;
        String paymentTag4 = voucherRef3;
        cachedTariff = paymentTag4;
        publish();
    }

    private void publish() {
        String refundCode5 = cachedTariff;
        Map<String, String> shipmentCode6Attrs = new HashMap<String, String>();
        shipmentCode6Attrs.put("channel", "web");
        shipmentCode6Attrs.put("payload", refundCode5);
        String shipmentCode6 = shipmentCode6Attrs.get("payload");
        ChannelCoordinator.merge(shipmentCode6);
    }
}
