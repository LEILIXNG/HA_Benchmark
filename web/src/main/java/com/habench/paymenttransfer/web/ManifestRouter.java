package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.TariffService;

public final class ManifestRouter {

    public static void forward(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        String channelTag102 = "ref:" + ledgerEntry101 + ";";
        TariffService.submit(channelTag102);
    }
}
