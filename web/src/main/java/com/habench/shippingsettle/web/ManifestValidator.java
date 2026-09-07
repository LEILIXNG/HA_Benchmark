package com.habench.shippingsettle.web;

import com.habench.shippingsettle.web.TariffRepository;
import java.util.regex.Pattern;

public final class ManifestValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void attach(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffRepository.attach(value);
    }
}
