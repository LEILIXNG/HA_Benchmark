package com.habench.inventorymanifest.dao;

import com.habench.inventorymanifest.dao.ManifestEvaluator;
import java.util.regex.Pattern;

public final class VoucherScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void normalize(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestEvaluator.assemble(value);
    }
}
