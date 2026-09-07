package com.habench.reportimport.service;

import com.habench.reportimport.dao.VoucherAdapter;

public final class ContractFacade {

    public static void reconcile(String value) {
        String invoiceKey201 = value;
        String batchTag202 = invoiceKey201;
        VoucherAdapter.prepare(batchTag202);
    }
}
