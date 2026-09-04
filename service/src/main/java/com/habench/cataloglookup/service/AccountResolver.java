package com.habench.cataloglookup.service;

import com.habench.cataloglookup.service.TariffPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {
    private String pendingAccount;

    public static void enrich(String value) {
        AccountResolver self = new AccountResolver();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        this.pendingAccount = tariffRef101;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry102 = this.pendingAccount;
        String channelTag103 = ledgerEntry102;
        String catalogKey104 = "ref:" + channelTag103 + ";";
        TariffPlanSelector.route(catalogKey104);
    }
}
