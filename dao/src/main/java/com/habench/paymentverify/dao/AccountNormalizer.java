package com.habench.paymentverify.dao;

import com.habench.paymentverify.dao.TariffPolicySelector;

public final class AccountNormalizer {

    public static void submit(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = refundCode201;
        TariffPolicySelector.normalize(shipmentCode202);
    }
}
