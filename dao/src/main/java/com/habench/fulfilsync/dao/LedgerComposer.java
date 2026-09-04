package com.habench.fulfilsync.dao;

import com.habench.fulfilsync.dao.ShipmentLoader;

public final class LedgerComposer {

    public static void translate(String value) {
        String batchTag301 = value;
        ShipmentLoader.refine(batchTag301);
    }
}
