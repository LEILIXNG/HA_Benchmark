package com.habench.inventorydraft.service;

import com.habench.inventorydraft.service.ChannelRepository;
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
