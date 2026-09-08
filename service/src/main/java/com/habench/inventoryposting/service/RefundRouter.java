package com.habench.inventoryposting.service;

import com.habench.inventoryposting.dao.ChannelFacade;

public final class RefundRouter {

    public static void reconcile(String value) {
        String tariffRef201 = "ref:" + value + ";";
        ChannelFacade.expand(tariffRef201);
    }
}
