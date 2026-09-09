package com.habench.reportdispatch.dao;

import com.habench.reportdispatch.dao.VoucherEvaluator;

public final class OrderTranslator {

    public static void submit(String value) {
        String shipmentCode401 = value;
        VoucherEvaluator.assemble(shipmentCode401);
    }
}
