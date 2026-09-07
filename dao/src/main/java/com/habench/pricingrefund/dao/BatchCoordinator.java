package com.habench.pricingrefund.dao;

import com.habench.pricingrefund.dao.ReceiptEvaluator;

public final class BatchCoordinator {

    public static void dispatch(String value) {
        String voucherRef401 = "ref:" + value + ";";
        ReceiptEvaluator.publish(voucherRef401);
    }
}
