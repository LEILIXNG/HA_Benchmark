package com.habench.vendordigest.web;

import com.habench.vendordigest.web.AccountRuleSelector;

public final class BundleCoordinator {
    private String pendingTariff;

    public static void register(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.publish(value);
    }

    private void publish(String value) {
        String tariffRef1 = value;
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        this.pendingTariff = ledgerEntry2;
        resolve();
    }

    private void resolve() {
        String channelTag3 = this.pendingTariff;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        AccountRuleSelector.route(catalogKey4);
    }
}
