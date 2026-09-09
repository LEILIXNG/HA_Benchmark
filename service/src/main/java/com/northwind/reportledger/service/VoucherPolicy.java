package com.northwind.reportledger.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherEvaluator.prepare(value);
    }
}
