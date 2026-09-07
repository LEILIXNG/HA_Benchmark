package com.habench.paymentreconcile.service;

import com.habench.paymentreconcile.dao.TariffEnricher;

public final class ContractAssembler {

    public static void dispatch(String value) {
        String accountRef201 = value;
        String voucherRef202 = accountRef201;
        TariffEnricher.translate(voucherRef202);
    }
}
