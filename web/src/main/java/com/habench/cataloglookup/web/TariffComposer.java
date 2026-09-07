package com.habench.cataloglookup.web;

import com.habench.cataloglookup.service.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffComposer {
    private String pendingShipment;

    public static void publish(String value) {
        TariffComposer self = new TariffComposer();
        self.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef101 = value;
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        this.pendingShipment = ledgerEntry102;
        prepare();
    }

    private void prepare() {
        String channelTag103 = this.pendingShipment;
        String catalogKey104 = channelTag103;
        this.pendingShipment = catalogKey104;
        forward();
    }

    private void forward() {
        String receiptKey105 = this.pendingShipment;
        Map<String, String> accountRef106Attrs = new HashMap<String, String>();
        accountRef106Attrs.put("channel", "web");
        accountRef106Attrs.put("payload", receiptKey105);
        String accountRef106 = accountRef106Attrs.get("payload");
        RefundComposer.compose(accountRef106);
    }
}
