package com.habench.pricingsplit.service;

import com.habench.pricingsplit.service.CatalogFacade;
import java.util.regex.Pattern;

public final class BatchGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        CatalogFacade.normalize(value);
    }
}
