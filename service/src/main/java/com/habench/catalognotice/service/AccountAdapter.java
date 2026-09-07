package com.habench.catalognotice.service;

import com.habench.catalognotice.dao.ManifestResolver;

public final class AccountAdapter {

    public static void normalize(String value) {
        String channelTag101 = value;
        ManifestResolver.merge(channelTag101);
    }
}
