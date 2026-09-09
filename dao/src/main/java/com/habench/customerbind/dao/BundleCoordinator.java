package com.habench.customerbind.dao;

import com.habench.customerbind.dao.BatchAssembler;

public final class BundleCoordinator {

    public static void stage(String value) {
        String manifestKey301 = value;
        BatchAssembler.collect(manifestKey301);
    }
}
