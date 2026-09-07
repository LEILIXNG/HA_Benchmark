package com.habench.accountcapture.web;

import com.habench.accountcapture.web.ChannelStrategySelector;
import java.util.regex.Pattern;

public final class InvoiceFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void dispatch(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelStrategySelector.forward(value);
    }
}
