package com.habench.catalogarchive.web;

import com.habench.catalogarchive.service.BundleResolver;

public final class VoucherService {

    public static void attach(String value) {
        String voucherRef101 = "ref:" + value + ";";
        BundleResolver.translate(voucherRef101);
    }
}
