package com.habench.fulfilsettle.dao;

import com.habench.fulfilsettle.dao.VoucherGuard;

public final class VoucherResolver {

    public static void resolve(String value) {
        String tariffRef301 = value;
        VoucherGuard.refine(tariffRef301);
    }
}
