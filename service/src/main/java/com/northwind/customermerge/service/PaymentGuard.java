package com.northwind.customermerge.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 客户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountExecutor.normalize(value);
    }
}
