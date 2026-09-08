package com.habench.paymentquote.dao;

import com.habench.paymentquote.dao.RefundAssembler;

public final class InvoiceRouter {

    public static void submit(String value) {
        String invoiceKey301 = value;
        String batchTag302 = "ref:" + invoiceKey301 + ";";
        RefundAssembler.normalize(batchTag302);
    }
}
