package com.habench.customerassign.dao;

import com.habench.customerassign.dao.BatchAssembler;

public final class BundleCoordinator {

    public static void stage(String value) {
        String manifestKey301 = value;
        BatchAssembler.collect(manifestKey301);
    }
}
