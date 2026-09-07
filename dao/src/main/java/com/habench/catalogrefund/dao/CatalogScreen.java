package com.habench.catalogrefund.dao;

import com.habench.catalogrefund.dao.BatchRepository;
import java.util.regex.Pattern;

public final class CatalogScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BatchRepository.reconcile(value);
    }
}
