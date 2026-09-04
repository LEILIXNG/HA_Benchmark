package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.ReceiptRepository;
import java.util.regex.Pattern;

public final class RefundGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ReceiptRepository.submit(value);
    }
}
