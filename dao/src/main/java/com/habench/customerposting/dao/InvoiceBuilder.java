package com.habench.customerposting.dao;

import com.habench.customerposting.dao.ContractEvaluator;

public final class InvoiceBuilder {

    public static void refine(String value) {
        String refundCode501 = "ref:" + value + ";";
        String shipmentCode502 = "ref:" + refundCode501 + ";";
        ContractEvaluator.merge(shipmentCode502);
    }
}
