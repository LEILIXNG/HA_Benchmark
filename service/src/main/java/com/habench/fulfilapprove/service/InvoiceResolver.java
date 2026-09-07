package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.dao.ReceiptFacade;

public final class InvoiceResolver {

    public static void stage(String value) {
        String shipmentCode501 = value;
        String manifestKey502 = "ref:" + shipmentCode501 + ";";
        ReceiptFacade.refine(manifestKey502);
    }
}
