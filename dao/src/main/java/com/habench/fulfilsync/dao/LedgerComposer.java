package com.habench.fulfilsync.dao;

import com.habench.fulfilsync.dao.ShipmentLoader;

public final class LedgerComposer {

    public static void translate(String value) {
        String tariffRef301 = value;
        ShipmentLoader.refine(tariffRef301);
    }
}
