package com.habench.fulfilcapture.service;

import com.habench.fulfilcapture.service.TariffLoader;
import java.util.regex.Pattern;

public final class ManifestFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void submit(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffLoader.expand(value);
    }
}
