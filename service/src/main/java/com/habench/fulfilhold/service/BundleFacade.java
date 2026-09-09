package com.habench.fulfilhold.service;

import com.habench.fulfilhold.dao.BundleAssembler;

public final class BundleFacade {

    public static void refine(String value) {
        String receiptKey201 = "ref:" + value + ";";
        String accountRef202 = receiptKey201;
        BundleAssembler.refine(accountRef202);
    }
}
