package com.northwind.shippingarchive.service;

import com.northwind.platform.ValidationException;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class LedgerGuard {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerGuard.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        SessionLoader.submit(value);
    }
}
