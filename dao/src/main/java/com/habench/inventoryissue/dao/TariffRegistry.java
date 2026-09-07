package com.habench.inventoryissue.dao;

import com.habench.inventoryissue.dao.CatalogPlanSelector;

public final class TariffRegistry {
    private String pendingManifest;

    public static void reconcile(String value) {
        TariffRegistry self = new TariffRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = "ref:" + ledgerEntry201 + ";";
        this.pendingManifest = channelTag202;
        merge();
    }

    private void merge() {
        String catalogKey203 = this.pendingManifest;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        String accountRef205 = "ref:" + receiptKey204 + ";";
        CatalogPlanSelector.stage(accountRef205);
    }
}
