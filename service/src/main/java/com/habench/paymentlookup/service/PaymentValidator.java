package com.habench.paymentlookup.service;

import com.habench.paymentlookup.service.ChannelRepository;
import java.util.regex.Pattern;

public final class PaymentValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelRepository.prepare(value);
    }
}
