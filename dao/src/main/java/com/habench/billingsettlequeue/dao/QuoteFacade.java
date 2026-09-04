package com.habench.billingsettlequeue.dao;

import com.habench.billingsettlequeue.dao.RefundEnricher;

public final class QuoteFacade {

    public static void forward(String value) {
        String invoiceKey501 = value;
        String batchTag502 = "ref:" + invoiceKey501 + ";";
        RefundEnricher.assemble(batchTag502);
    }
}
