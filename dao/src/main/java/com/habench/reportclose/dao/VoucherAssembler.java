package com.habench.reportclose.dao;

import com.habench.reportclose.dao.BatchValidator;

public final class VoucherAssembler {

    public static void normalize(String value) {
        String manifestKey201 = value;
        String invoiceKey202 = manifestKey201;
        BatchValidator.expand(invoiceKey202);
    }
}
