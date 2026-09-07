package com.habench.ordersubmit.dao;

import com.habench.ordersubmit.dao.PaymentPlanSelector;

public final class InvoiceRouter {

    public static void translate(String value) {
        String catalogKey301 = value;
        PaymentPlanSelector.dispatch(catalogKey301);
    }
}
