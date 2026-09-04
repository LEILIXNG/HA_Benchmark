package com.habench.pricingreview.dao;

import com.habench.pricingreview.dao.ChannelRepository;
import java.util.regex.Pattern;

public final class QuoteScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void translate(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelRepository.stage(value);
    }
}
