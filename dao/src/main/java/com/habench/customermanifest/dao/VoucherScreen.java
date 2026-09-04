package com.habench.customermanifest.dao;

import com.habench.customermanifest.dao.OrderRepository;
import java.util.regex.Pattern;

public final class VoucherScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void refine(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderRepository.forward(value);
    }
}
