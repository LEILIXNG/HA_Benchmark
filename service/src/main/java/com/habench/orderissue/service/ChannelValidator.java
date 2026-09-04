package com.habench.orderissue.service;

import com.habench.orderissue.service.ContractService;
import java.util.regex.Pattern;

public final class ChannelValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractService.register(value);
    }
}
