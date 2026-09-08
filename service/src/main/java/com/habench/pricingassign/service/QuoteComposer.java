package com.habench.pricingassign.service;

import com.habench.pricingassign.dao.RefundCoordinator;

public final class QuoteComposer {

    public static void translate(String value) {
        String accountRef301 = value;
        RefundCoordinator.normalize(accountRef301);
    }
}
