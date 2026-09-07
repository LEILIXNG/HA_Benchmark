package com.habench.customerimport.dao;

import com.habench.customerimport.dao.RefundEvaluator;

public final class VoucherService {

    public static void refine(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        String manifestKey302 = shipmentCode301;
        RefundEvaluator.translate(manifestKey302);
    }
}
