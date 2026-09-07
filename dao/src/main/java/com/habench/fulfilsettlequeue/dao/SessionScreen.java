package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.LedgerExecutor;
import java.util.regex.Pattern;

public final class SessionScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        LedgerExecutor.compose(value);
    }
}
