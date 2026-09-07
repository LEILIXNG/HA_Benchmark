package com.habench.inventoryassign.dao;

import com.habench.inventoryassign.dao.AccountStrategySelector;

public final class ManifestTranslator {

    public static void compose(String value) {
        String refundCode201 = "ref:" + value + ";";
        AccountStrategySelector.stage(refundCode201);
    }
}
