package com.habench.reportimport.service;

import com.habench.reportimport.service.PaymentRepository;
import java.util.regex.Pattern;

public final class VoucherPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        PaymentRepository.prepare(value);
    }
}
