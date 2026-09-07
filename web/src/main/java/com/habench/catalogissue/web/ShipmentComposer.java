package com.habench.catalogissue.web;

import com.habench.catalogissue.service.TariffService;

public final class ShipmentComposer {

    public static void resolve(String value) {
        String channelTag101 = "ref:" + value + ";";
        TariffService.dispatch(channelTag101);
    }
}
