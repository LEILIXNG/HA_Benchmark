package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.dao.AccountFacade;
import java.util.HashMap;
import java.util.Map;

public final class TariffAdapter {
    private String pendingBundle;
    private static String cachedBundle;

    public static void merge(String value) {
        TariffAdapter self = new TariffAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        String tariffRef302 = quoteRef301;
        this.pendingBundle = tariffRef302;
        prepare();
    }

    private void prepare() {
        String ledgerEntry303 = this.pendingBundle;
        String channelTag304 = "ref:" + ledgerEntry303 + ";";
        String catalogKey305 = "ref:" + channelTag304 + ";";
        this.pendingBundle = catalogKey305;
        resolve();
    }

    private void resolve() {
        String receiptKey306 = this.pendingBundle;
        Map<String, String> accountRef307Attrs = new HashMap<String, String>();
        accountRef307Attrs.put("channel", "web");
        accountRef307Attrs.put("payload", receiptKey306);
        String accountRef307 = accountRef307Attrs.get("payload");
        Map<String, String> voucherRef308Attrs = new HashMap<String, String>();
        voucherRef308Attrs.put("channel", "web");
        voucherRef308Attrs.put("payload", accountRef307);
        String voucherRef308 = voucherRef308Attrs.get("payload");
        cachedBundle = voucherRef308;
        forward();
    }

    private void forward() {
        String paymentTag309 = cachedBundle;
        Map<String, String> refundCode310Attrs = new HashMap<String, String>();
        refundCode310Attrs.put("channel", "web");
        refundCode310Attrs.put("payload", paymentTag309);
        String refundCode310 = refundCode310Attrs.get("payload");
        Map<String, String> shipmentCode311Attrs = new HashMap<String, String>();
        shipmentCode311Attrs.put("channel", "web");
        shipmentCode311Attrs.put("payload", refundCode310);
        String shipmentCode311 = shipmentCode311Attrs.get("payload");
        AccountFacade.normalize(shipmentCode311);
    }
}
