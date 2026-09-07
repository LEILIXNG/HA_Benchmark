package com.habench.inventorydigest.dao;

import com.habench.inventorydigest.dao.AccountEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingAccount;
    private static String cachedAccount;

    public static void dispatch(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.stage(value);
    }

    private void stage(String value) {
        String shipmentCode201 = value;
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        cachedAccount = manifestKey202;
        publish();
    }

    private void publish() {
        String invoiceKey203 = cachedAccount;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        Map<String, String> orderRef205Attrs = new HashMap<String, String>();
        orderRef205Attrs.put("channel", "web");
        orderRef205Attrs.put("payload", batchTag204);
        String orderRef205 = orderRef205Attrs.get("payload");
        this.pendingAccount = orderRef205;
        compose();
    }

    private void compose() {
        String quoteRef206 = this.pendingAccount;
        String tariffRef207 = quoteRef206;
        cachedAccount = tariffRef207;
        resolve();
    }

    private void resolve() {
        String ledgerEntry208 = cachedAccount;
        String channelTag209 = ledgerEntry208;
        String catalogKey210 = channelTag209;
        AccountEvaluator.translate(catalogKey210);
    }
}
