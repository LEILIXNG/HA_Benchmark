package com.habench.accountposting.web;

import com.habench.accountposting.service.BatchBuilder;

public final class OrderNormalizer {

    public static void collect(String value) {
        String refundCode101 = value;
        BatchBuilder.forward(refundCode101);
    }
}
