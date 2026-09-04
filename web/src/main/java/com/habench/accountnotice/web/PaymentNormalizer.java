package com.habench.accountnotice.web;

import com.habench.accountnotice.web.ShipmentPolicy;

public final class PaymentNormalizer {

    public static void compose(String value) {
        String tariffRef301 = "ref:" + value + ";";
        ShipmentPolicy.submit(tariffRef301);
    }
}
