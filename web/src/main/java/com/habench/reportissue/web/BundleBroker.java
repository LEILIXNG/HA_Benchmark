package com.habench.reportissue.web;

import com.habench.reportissue.web.ReceiptBuilder;

public final class BundleBroker {

    public static void prepare(String value) {
        String batchTag101 = value;
        ReceiptBuilder.compose(batchTag101);
    }
}
