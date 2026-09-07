package com.habench.catalogassign.dao;

import com.habench.catalogassign.dao.CatalogFetcher;
import java.util.regex.Pattern;

public final class InvoiceScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void forward(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        CatalogFetcher.resolve(value);
    }
}
