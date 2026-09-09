package com.habench.accountreconcile.web;

import com.habench.accountreconcile.service.SessionTranslator;

public final class LedgerService {

    public static void translate(String value) {
        String manifestKey201 = "ref:" + value + ";";
        SessionTranslator.expand(manifestKey201);
    }
}
