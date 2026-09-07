package com.habench.reportposting.service;

import com.habench.reportposting.dao.RefundCoordinator;

public final class VoucherRouter {

    public static void refine(String value) {
        String receiptKey301 = value;
        RefundCoordinator.route(receiptKey301);
    }
}
