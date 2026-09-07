package com.habench.customerdigest.service;

import com.habench.customerdigest.service.BatchRepository;
import java.util.regex.Pattern;

public final class RefundValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void collect(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BatchRepository.reconcile(value);
    }
}
