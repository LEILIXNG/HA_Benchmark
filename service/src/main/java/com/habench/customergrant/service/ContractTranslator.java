package com.habench.customergrant.service;

import com.habench.customergrant.dao.AccountService;

public final class ContractTranslator {
    private static String cachedTariff;

    public static void dispatch(String value) {
        String paymentTag101 = value;
        String refundCode102 = "ref:" + paymentTag101 + ";";
        cachedTariff = refundCode102;
        compose();
    }

    private static void compose() {
        String shipmentCode103 = cachedTariff;
        String manifestKey104 = shipmentCode103;
        AccountService.forward(manifestKey104);
    }
}
