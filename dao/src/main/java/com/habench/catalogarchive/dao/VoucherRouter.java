package com.habench.catalogarchive.dao;

import com.habench.catalogarchive.dao.ShipmentExecutor;

public final class VoucherRouter {

    public static void compose(String value) {
        String channelTag301 = "ref:" + value + ";";
        String catalogKey302 = "ref:" + channelTag301 + ";";
        ShipmentExecutor.translate(catalogKey302);
    }
}
