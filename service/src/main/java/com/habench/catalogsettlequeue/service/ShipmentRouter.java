package com.habench.catalogsettlequeue.service;

import com.habench.catalogsettlequeue.service.ChannelRouter;

public final class ShipmentRouter {

    public static void assemble(String value) {
        String channelTag101 = value;
        String catalogKey102 = channelTag101;
        ChannelRouter.attach(catalogKey102);
    }
}
