package com.habench.vendortrace.service;

import com.habench.vendortrace.service.ManifestRepository;
import java.util.regex.Pattern;

public final class ChannelScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestRepository.resolve(value);
    }
}
