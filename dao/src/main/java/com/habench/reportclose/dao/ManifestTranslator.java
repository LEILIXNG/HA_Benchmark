package com.habench.reportclose.dao;

import com.habench.reportclose.dao.AccountRouter;

public final class ManifestTranslator {

    public static void enrich(String value) {
        String catalogKey401 = "ref:" + value + ";";
        AccountRouter.publish(catalogKey401);
    }
}
