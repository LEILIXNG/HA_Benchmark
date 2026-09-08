package com.habench.accountclose.service;

import com.habench.accountclose.service.ShipmentGateway;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {
    private String pendingShipment;

    public static void collect(String value) {
        AccountBuilder self = new AccountBuilder();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = tariffRef101;
        this.pendingShipment = ledgerEntry102;
        prepare();
    }

    private void prepare() {
        String channelTag103 = this.pendingShipment;
        String catalogKey104 = "ref:" + channelTag103 + ";";
        Map<String, String> receiptKey105Attrs = new HashMap<String, String>();
        receiptKey105Attrs.put("channel", "web");
        receiptKey105Attrs.put("payload", catalogKey104);
        String receiptKey105 = receiptKey105Attrs.get("payload");
        ShipmentGateway.translate(receiptKey105);
    }
}
