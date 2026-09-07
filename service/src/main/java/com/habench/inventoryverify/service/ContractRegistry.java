package com.habench.inventoryverify.service;

import com.habench.inventoryverify.dao.VoucherService;

public final class ContractRegistry {

    public static void reconcile(String value) {
        String catalogKey201 = "ref:" + value + ";";
        VoucherService.register(catalogKey201);
    }
}
