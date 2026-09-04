package com.habench.reportissue.web;

import com.habench.reportissue.web.CatalogStrategySelector;

public final class ContractNormalizer {

    public static void reconcile(String value) {
        String channelTag1 = value;
        String catalogKey2 = "ref:" + channelTag1 + ";";
        CatalogStrategySelector.normalize(catalogKey2);
    }
}
