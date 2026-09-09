package com.northwind.catalogreopen.dao;

import com.northwind.platform.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class SessionPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(SessionPolicy.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void assemble(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        OrderEvaluator.register(value);
    }
}
