package com.habench.catalogadjust.dao;

import com.habench.catalogadjust.dao.InvoiceExecutor;
import java.util.regex.Pattern;

public final class ChannelValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        InvoiceExecutor.assemble(value);
    }
}
