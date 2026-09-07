package com.habench.inventoryissue.dao;

import com.habench.inventoryissue.dao.BatchRouter;

public final class ManifestEnricher {

    public static void translate(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        BatchRouter.assemble(invoiceKey301);
    }
}
