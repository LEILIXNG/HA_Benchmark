package com.habench.pricingtrace.dao;

import com.habench.pricingtrace.dao.TariffGateway;
import java.util.HashMap;
import java.util.Map;

public final class SessionAdapter {
    private String pendingTariff;
    private static String cachedTariff;

    public static void attach(String value) {
        SessionAdapter self = new SessionAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag301 = value;
        String catalogKey302 = "ref:" + channelTag301 + ";";
        this.pendingTariff = catalogKey302;
        enrich();
    }

    private void enrich() {
        String receiptKey303 = this.pendingTariff;
        Map<String, String> accountRef304Attrs = new HashMap<String, String>();
        accountRef304Attrs.put("channel", "web");
        accountRef304Attrs.put("payload", receiptKey303);
        String accountRef304 = accountRef304Attrs.get("payload");
        cachedTariff = accountRef304;
        expand();
    }

    private void expand() {
        String voucherRef305 = cachedTariff;
        String paymentTag306 = "ref:" + voucherRef305 + ";";
        Map<String, String> refundCode307Attrs = new HashMap<String, String>();
        refundCode307Attrs.put("channel", "web");
        refundCode307Attrs.put("payload", paymentTag306);
        String refundCode307 = refundCode307Attrs.get("payload");
        TariffGateway.translate(refundCode307);
    }
}
