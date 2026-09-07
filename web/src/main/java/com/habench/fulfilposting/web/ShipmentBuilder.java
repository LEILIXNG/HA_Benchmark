package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.InvoiceFacade;

public final class ShipmentBuilder {

    public static void stage(String value) {
        String accountRef1 = value;
        String voucherRef2 = "ref:" + accountRef1 + ";";
        InvoiceFacade.dispatch(voucherRef2);
    }
}
