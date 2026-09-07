package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.ShipmentExecutor;

public final class VoucherRouter {

    public static void compose(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = ledgerEntry201;
        ShipmentExecutor.translate(channelTag202);
    }
}
