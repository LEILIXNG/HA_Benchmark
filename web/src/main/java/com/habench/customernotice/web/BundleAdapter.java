package com.habench.customernotice.web;

import com.habench.customernotice.service.SessionComposer;

public final class BundleAdapter {

    public static void attach(String value) {
        String receiptKey1 = "ref:" + value + ";";
        String accountRef2 = "ref:" + receiptKey1 + ";";
        SessionComposer.normalize(accountRef2);
    }
}
