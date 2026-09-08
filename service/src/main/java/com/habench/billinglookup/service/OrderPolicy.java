package com.habench.billinglookup.service;

import com.habench.billinglookup.service.ContractGateway;
import java.util.regex.Pattern;

public final class OrderPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractGateway.assemble(value);
    }
}
