package com.habench.billingsettlequeue.service;

import com.habench.billingsettlequeue.service.TariffCoordinator;

public final class InvoiceAssembler {

    public static void publish(String value) {
        String voucherRef301 = value;
        String paymentTag302 = "ref:" + voucherRef301 + ";";
        TariffCoordinator.reconcile(paymentTag302);
    }
}
