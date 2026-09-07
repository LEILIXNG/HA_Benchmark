package com.habench.catalogissue.dao;

import com.habench.catalogissue.dao.RefundEvaluator;

public final class CatalogEnricher {

    public static void dispatch(String value) {
        String channelTag401 = value;
        String catalogKey402 = "ref:" + channelTag401 + ";";
        RefundEvaluator.prepare(catalogKey402);
    }
}
