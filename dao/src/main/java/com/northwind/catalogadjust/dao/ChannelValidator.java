package com.northwind.catalogadjust.dao;

import com.northwind.platform.ValidationException;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelValidator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelValidator.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        InvoiceExecutor.assemble(value);
    }
}
