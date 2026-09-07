package com.habench.fulfilissue.service;

import com.habench.fulfilissue.dao.RefundCoordinator;

public final class QuoteComposer {

    public static void translate(String value) {
        String accountRef301 = value;
        RefundCoordinator.normalize(accountRef301);
    }
}
