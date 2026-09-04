package com.habench.vendorlookup.dao;

import com.habench.vendorlookup.dao.RefundRepository;
import java.util.regex.Pattern;

public final class CatalogScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        RefundRepository.register(value);
    }
}
