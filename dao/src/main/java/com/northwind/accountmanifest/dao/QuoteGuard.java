package com.northwind.accountmanifest.dao;

import com.northwind.platform.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        VoucherRepository.compose(value);
    }
}
