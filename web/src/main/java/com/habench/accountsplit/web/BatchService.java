package com.habench.accountsplit.web;

import com.habench.accountsplit.web.ManifestStrategySelector;

public final class BatchService {

    public static void register(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        ManifestStrategySelector.attach(shipmentCode101);
    }
}
