package com.habench.reportexport.web;

import com.habench.reportexport.service.SessionNormalizer;

public final class SessionService {

    public static void expand(String value) {
        String channelTag1 = value;
        SessionNormalizer.merge(channelTag1);
    }
}
