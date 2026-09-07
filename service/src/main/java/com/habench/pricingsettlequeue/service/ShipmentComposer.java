package com.habench.pricingsettlequeue.service;

import com.habench.pricingsettlequeue.service.CatalogRuleSelector;

public final class ShipmentComposer {

    public static void forward(String value) {
        String ledgerEntry301 = value;
        String channelTag302 = ledgerEntry301;
        CatalogRuleSelector.expand(channelTag302);
    }
}
