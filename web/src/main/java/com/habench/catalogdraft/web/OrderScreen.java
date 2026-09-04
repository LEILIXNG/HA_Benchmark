package com.habench.catalogdraft.web;

import com.habench.catalogdraft.web.BundleFacade;
import java.util.regex.Pattern;

public final class OrderScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BundleFacade.refine(value);
    }
}
