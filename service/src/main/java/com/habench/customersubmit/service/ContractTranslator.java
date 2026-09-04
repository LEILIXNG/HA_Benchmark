package com.habench.customersubmit.service;

import com.habench.customersubmit.service.VoucherRouter;

public final class ContractTranslator {

    public static void merge(String value) {
        String shipmentCode301 = value;
        VoucherRouter.submit(shipmentCode301);
    }
}
