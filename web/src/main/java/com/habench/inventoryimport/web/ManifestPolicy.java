package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.QuoteAdapter;
import java.util.regex.Pattern;

public final class ManifestPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void translate(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        QuoteAdapter.forward(value);
    }
}
