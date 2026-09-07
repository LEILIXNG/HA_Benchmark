package com.habench.customerexport.service;

import com.habench.customerexport.service.VoucherRepository;
import java.util.regex.Pattern;

public final class BatchScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherRepository.reconcile(value);
    }
}
