package com.habench.inventoryposting.service;

import com.habench.inventoryposting.service.ContractLoader;
import java.util.regex.Pattern;

public final class CatalogFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractLoader.attach(value);
    }
}
