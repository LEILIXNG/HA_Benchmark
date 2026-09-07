package com.habench.inventoryreconcile.dao;

import com.habench.inventoryreconcile.dao.ManifestLoader;

public final class InvoiceEnricher {

    public static void stage(String value) {
        String accountRef501 = value;
        ManifestLoader.stage(accountRef501);
    }
}
