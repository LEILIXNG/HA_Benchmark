package com.habench.reportclose.web;

import com.habench.reportclose.service.BatchAdapter;

public final class BatchFacade {

    public static void dispatch(String value) {
        String catalogKey101 = "ref:" + value + ";";
        BatchAdapter.normalize(catalogKey101);
    }
}
