package com.habench.inventorysettle.dao;

import com.habench.inventorysettle.dao.RefundEvaluator;
import java.util.regex.Pattern;

public final class ContractValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void forward(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        RefundEvaluator.normalize(value);
    }
}
