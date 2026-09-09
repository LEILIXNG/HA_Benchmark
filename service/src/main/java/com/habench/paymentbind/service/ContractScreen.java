package com.habench.paymentbind.service;

import com.habench.paymentbind.service.QuoteFacade;
import java.util.regex.Pattern;

public final class ContractScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        QuoteFacade.attach(value);
    }
}
