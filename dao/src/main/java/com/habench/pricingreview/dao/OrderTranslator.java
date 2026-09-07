package com.habench.pricingreview.dao;

import com.habench.pricingreview.dao.VoucherEvaluator;

public final class OrderTranslator {

    public static void submit(String value) {
        String shipmentCode401 = value;
        VoucherEvaluator.assemble(shipmentCode401);
    }
}
