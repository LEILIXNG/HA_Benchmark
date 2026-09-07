package com.habench.inventorydigest.service;

import com.habench.inventorydigest.dao.ShipmentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class AccountRegistry {
    private String pendingAccount;
    private static String cachedAccount;

    public static void route(String value) {
        AccountRegistry self = new AccountRegistry();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        String tariffRef102 = quoteRef101;
        cachedAccount = tariffRef102;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry103 = cachedAccount;
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        this.pendingAccount = channelTag104;
        submit();
    }

    private void submit() {
        String catalogKey105 = this.pendingAccount;
        String receiptKey106 = "ref:" + catalogKey105 + ";";
        cachedAccount = receiptKey106;
        assemble();
    }

    private void assemble() {
        String accountRef107 = cachedAccount;
        String voucherRef108 = accountRef107;
        Map<String, String> paymentTag109Attrs = new HashMap<String, String>();
        paymentTag109Attrs.put("channel", "web");
        paymentTag109Attrs.put("payload", voucherRef108);
        String paymentTag109 = paymentTag109Attrs.get("payload");
        ShipmentCoordinator.stage(paymentTag109);
    }
}
