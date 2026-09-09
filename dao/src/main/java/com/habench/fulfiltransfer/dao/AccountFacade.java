package com.habench.fulfiltransfer.dao;

import com.habench.fulfiltransfer.dao.QuoteRouter;

public final class AccountFacade {

    public static void normalize(String value) {
        String shipmentCode401 = value;
        QuoteRouter.route(shipmentCode401);
    }
}
