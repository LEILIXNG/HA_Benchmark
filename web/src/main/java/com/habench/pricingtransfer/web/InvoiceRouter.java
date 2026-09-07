package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.service.QuoteCoordinator;

public final class InvoiceRouter {

    public static void publish(String value) {
        String refundCode101 = "ref:" + value + ";";
        QuoteCoordinator.assemble(refundCode101);
    }
}
