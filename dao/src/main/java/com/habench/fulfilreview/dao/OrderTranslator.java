package com.habench.fulfilreview.dao;

import com.habench.fulfilreview.dao.VoucherEvaluator;

public final class OrderTranslator {

    public static void submit(String value) {
        String shipmentCode401 = value;
        VoucherEvaluator.assemble(shipmentCode401);
    }
}
