package com.habench.accountrollup.web;

import com.habench.accountrollup.service.SessionService;

public final class BatchNormalizer {

    public static void assemble(String value) {
        String accountRef1 = value;
        SessionService.prepare(accountRef1);
    }
}
