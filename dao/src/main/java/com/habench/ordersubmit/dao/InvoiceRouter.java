package com.habench.ordersubmit.dao;

import com.habench.ordersubmit.dao.PaymentPlanSelector;

public final class InvoiceRouter {

    public static void translate(String value) {
        String refundCode201 = value;
        String shipmentCode202 = refundCode201;
        PaymentPlanSelector.dispatch(shipmentCode202);
    }
}
