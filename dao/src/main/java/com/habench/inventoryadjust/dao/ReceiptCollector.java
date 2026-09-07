package com.habench.inventoryadjust.dao;

import com.habench.inventoryadjust.dao.AccountLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingAccount;

    public static void publish(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = shipmentCode301;
        this.pendingAccount = manifestKey302;
        enrich();
    }

    private void enrich() {
        String invoiceKey303 = this.pendingAccount;
        String batchTag304 = "ref:" + invoiceKey303 + ";";
        Map<String, String> orderRef305Attrs = new HashMap<String, String>();
        orderRef305Attrs.put("channel", "web");
        orderRef305Attrs.put("payload", batchTag304);
        String orderRef305 = orderRef305Attrs.get("payload");
        this.pendingAccount = orderRef305;
        compose();
    }

    private void compose() {
        String quoteRef306 = this.pendingAccount;
        String tariffRef307 = quoteRef306;
        this.pendingAccount = tariffRef307;
        normalize();
    }

    private void normalize() {
        String ledgerEntry308 = this.pendingAccount;
        String channelTag309 = ledgerEntry308;
        String catalogKey310 = channelTag309;
        AccountLoader.route(catalogKey310);
    }
}
