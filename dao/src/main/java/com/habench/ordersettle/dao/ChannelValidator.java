package com.habench.ordersettle.dao;

import com.habench.ordersettle.dao.ShipmentEvaluator;
import java.util.regex.Pattern;

public final class ChannelValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void assemble(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentEvaluator.forward(value);
    }
}
