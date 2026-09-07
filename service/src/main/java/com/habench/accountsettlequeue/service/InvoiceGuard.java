package com.habench.accountsettlequeue.service;

import com.habench.accountsettlequeue.service.ManifestRepository;
import java.util.regex.Pattern;

public final class InvoiceGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void refine(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestRepository.submit(value);
    }
}
