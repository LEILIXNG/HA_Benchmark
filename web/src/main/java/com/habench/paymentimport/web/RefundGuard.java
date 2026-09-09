package com.habench.paymentimport.web;

import com.habench.paymentimport.web.ContractService;
import java.util.regex.Pattern;

public final class RefundGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractService.reconcile(value);
    }
}
