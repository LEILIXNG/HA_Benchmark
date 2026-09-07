package com.habench.customernotice.dao;

import com.habench.customernotice.dao.VoucherBuilder;

public final class AccountNormalizer {

    public static void normalize(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        VoucherBuilder.expand(manifestKey202);
    }
}
