package com.habench.customerexport.dao;

import com.habench.customerexport.dao.VoucherRepository;

public final class BatchTranslator {

    public static void prepare(String value) {
        String voucherRef301 = value;
        VoucherRepository.reconcile(voucherRef301);
    }
}
