package com.habench.inventorysync.service;

import com.habench.inventorysync.dao.ManifestResolver;

public final class RefundNormalizer {

    public static void dispatch(String value) {
        String refundCode201 = value;
        ManifestResolver.route(refundCode201);
    }
}
