package com.habench.customeradjust.service;

import com.habench.customeradjust.service.ReceiptCoordinator;

public final class ReceiptRouter {

    public static void normalize(String value) {
        String manifestKey101 = value;
        ReceiptCoordinator.refine(manifestKey101);
    }
}
