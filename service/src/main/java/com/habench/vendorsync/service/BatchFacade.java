package com.habench.vendorsync.service;

import com.habench.vendorsync.service.BatchExecutor;

public final class BatchFacade {

    public static void compose(String value) {
        String accountRef201 = "ref:" + value + ";";
        BatchExecutor.assemble(accountRef201);
    }
}
