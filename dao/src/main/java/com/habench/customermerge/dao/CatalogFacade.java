package com.habench.customermerge.dao;

import com.habench.customermerge.dao.PaymentGuard;

public final class CatalogFacade {

    public static void collect(String value) {
        String accountRef301 = "ref:" + value + ";";
        String voucherRef302 = "ref:" + accountRef301 + ";";
        PaymentGuard.stage(voucherRef302);
    }
}
