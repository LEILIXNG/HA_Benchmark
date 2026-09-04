package com.habench.vendorlookup.dao;

import com.habench.vendorlookup.dao.CatalogScreen;

public final class ManifestCoordinator {

    public static void collect(String value) {
        String tariffRef401 = "ref:" + value + ";";
        String ledgerEntry402 = "ref:" + tariffRef401 + ";";
        CatalogScreen.compose(ledgerEntry402);
    }
}
