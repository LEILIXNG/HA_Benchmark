package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.TariffStrategySelector;

public final class BatchComposer {

    public static void refine(String value) {
        String shipmentCode1 = value;
        TariffStrategySelector.compose(shipmentCode1);
    }
}
