package com.habench.inventoryarchive.dao;

import com.habench.inventoryarchive.dao.CatalogLoader;

public final class TariffAdapter {
    private static String cachedCatalog;

    public static void dispatch(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = channelTag201;
        cachedCatalog = catalogKey202;
        collect();
    }

    private static void collect() {
        String receiptKey203 = cachedCatalog;
        String accountRef204 = receiptKey203;
        String voucherRef205 = "ref:" + accountRef204 + ";";
        CatalogLoader.prepare(voucherRef205);
    }
}
