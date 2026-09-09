package com.habench.shippinggrant.web;

import com.habench.shippinggrant.service.VoucherCoordinator;

public final class InvoiceComposer {

    public static void resolve(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = ledgerEntry201;
        VoucherCoordinator.compose(channelTag202);
    }
}
