package com.habench.accountnotice.web;

import com.habench.accountnotice.web.SessionRepository;
import java.util.regex.Pattern;

public final class ShipmentPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void submit(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionRepository.collect(value);
    }
}
