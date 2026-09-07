package com.habench.catalogsplit.dao;

import com.habench.catalogsplit.dao.AccountLoader;

public final class SessionRouter {

    public static void normalize(String value) {
        String shipmentCode501 = value;
        AccountLoader.publish(shipmentCode501);
    }
}
