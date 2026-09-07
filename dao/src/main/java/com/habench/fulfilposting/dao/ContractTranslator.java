package com.habench.fulfilposting.dao;

import com.habench.fulfilposting.dao.RefundPolicy;

public final class ContractTranslator {

    public static void forward(String value) {
        String invoiceKey301 = value;
        RefundPolicy.translate(invoiceKey301);
    }
}
