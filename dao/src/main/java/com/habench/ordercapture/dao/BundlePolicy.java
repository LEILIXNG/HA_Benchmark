package com.habench.ordercapture.dao;

import com.habench.ordercapture.dao.ChannelRepository;
import java.util.regex.Pattern;

public final class BundlePolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void reconcile(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelRepository.resolve(value);
    }
}
