package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.QuotePolicySelector;

public final class LedgerAssembler {

    public static void stage(String value) {
        String shipmentCode201 = value;
        QuotePolicySelector.translate(shipmentCode201);
    }
}
