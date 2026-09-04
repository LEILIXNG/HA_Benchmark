package com.habench.paymentrenewal.service;

import com.habench.paymentrenewal.service.VoucherRepository;
import java.util.regex.Pattern;

public final class ChannelValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void expand(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherRepository.expand(value);
    }
}
