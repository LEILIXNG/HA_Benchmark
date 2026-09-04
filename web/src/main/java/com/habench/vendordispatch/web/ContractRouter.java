package com.habench.vendordispatch.web;

import com.habench.vendordispatch.service.ManifestRouter;

public final class ContractRouter {

    public static void route(String value) {
        String voucherRef1 = "ref:" + value + ";";
        ManifestRouter.dispatch(voucherRef1);
    }
}
