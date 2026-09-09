package com.habench.reportreconcile.service;

import com.habench.reportreconcile.dao.RefundCoordinator;

public final class QuoteComposer {

    public static void translate(String value) {
        String accountRef301 = value;
        RefundCoordinator.normalize(accountRef301);
    }
}
