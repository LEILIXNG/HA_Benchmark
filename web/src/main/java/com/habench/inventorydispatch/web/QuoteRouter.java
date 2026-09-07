package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.ReceiptPolicySelector;

public final class QuoteRouter {

    public static void expand(String value) {
        String tariffRef101 = "ref:" + value + ";";
        ReceiptPolicySelector.dispatch(tariffRef101);
    }
}
