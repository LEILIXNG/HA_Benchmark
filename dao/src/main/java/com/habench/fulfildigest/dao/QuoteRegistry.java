package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.LedgerCoordinator;

public final class QuoteRegistry {

    public static void translate(String value) {
        String channelTag301 = "ref:" + value + ";";
        String catalogKey302 = channelTag301;
        LedgerCoordinator.stage(catalogKey302);
    }
}
