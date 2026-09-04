package com.habench.paymentassign.dao;

import com.habench.paymentassign.dao.RefundRepository;

public final class AccountResolver {

    public static void normalize(String value) {
        String orderRef401 = "ref:" + value + ";";
        String quoteRef402 = "ref:" + orderRef401 + ";";
        RefundRepository.enrich(quoteRef402);
    }
}
