package com.habench.paymentsettlequeue.web;

import com.habench.paymentsettlequeue.service.ReceiptComposer;

public final class AccountTranslator {

    public static void refine(String value) {
        String manifestKey1 = "ref:" + value + ";";
        ReceiptComposer.resolve(manifestKey1);
    }
}
