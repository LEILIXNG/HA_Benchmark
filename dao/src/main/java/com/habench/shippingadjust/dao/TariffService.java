package com.habench.shippingadjust.dao;

import com.habench.shippingadjust.dao.ContractEvaluator;

public final class TariffService {

    public static void submit(String value) {
        String voucherRef301 = "ref:" + value + ";";
        ContractEvaluator.attach(voucherRef301);
    }
}
