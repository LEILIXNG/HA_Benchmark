package com.habench.shippingrenewal.web;

import com.habench.shippingrenewal.web.ChannelRegistry;

public final class TariffNormalizer {

    public static void normalize(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = voucherRef101;
        ChannelRegistry.stage(paymentTag102);
    }
}
