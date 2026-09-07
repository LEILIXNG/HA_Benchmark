package com.habench.paymentapprove.service;

import com.habench.paymentapprove.dao.PaymentCollector;

public final class VoucherEnricher {

    public static void dispatch(String value) {
        String refundCode101 = value;
        String shipmentCode102 = refundCode101;
        PaymentCollector.publish(shipmentCode102);
    }
}
