package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.TariffStrategySelector;

public final class ReceiptAdapter {

    public static void stage(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = accountRef201;
        TariffStrategySelector.translate(voucherRef202);
    }
}
