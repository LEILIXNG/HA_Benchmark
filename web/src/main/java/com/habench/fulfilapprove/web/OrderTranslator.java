package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.web.SessionPolicySelector;

public final class OrderTranslator {

    public static void assemble(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        SessionPolicySelector.route(accountRef2);
    }
}
