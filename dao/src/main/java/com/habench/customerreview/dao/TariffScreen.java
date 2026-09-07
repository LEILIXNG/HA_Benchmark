package com.habench.customerreview.dao;

import com.habench.customerreview.dao.RefundRepository;
import java.util.regex.Pattern;

public final class TariffScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void expand(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        RefundRepository.stage(value);
    }
}
