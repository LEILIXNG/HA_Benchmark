package com.habench.inventorysettlequeue.service;

import com.habench.inventorysettlequeue.dao.BatchRegistry;

public final class AccountFacade {

    public static void prepare(String value) {
        String refundCode301 = "ref:" + value + ";";
        BatchRegistry.reconcile(refundCode301);
    }
}
