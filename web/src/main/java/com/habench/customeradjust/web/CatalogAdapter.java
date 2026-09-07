package com.habench.customeradjust.web;

import com.habench.customeradjust.service.SessionAssembler;

public final class CatalogAdapter {

    public static void enrich(String value) {
        String orderRef1 = "ref:" + value + ";";
        SessionAssembler.publish(orderRef1);
    }
}
