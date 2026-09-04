package com.habench.customerledger.dao;

import com.habench.customerledger.dao.PaymentRepository;
import java.util.regex.Pattern;

public final class TariffPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void attach(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        PaymentRepository.submit(value);
    }
}
