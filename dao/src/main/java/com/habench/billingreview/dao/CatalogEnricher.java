package com.habench.billingreview.dao;

import com.habench.billingreview.dao.ManifestExecutor;

public final class CatalogEnricher {

    public static void resolve(String value) {
        String refundCode401 = value;
        ManifestExecutor.prepare(refundCode401);
    }
}
