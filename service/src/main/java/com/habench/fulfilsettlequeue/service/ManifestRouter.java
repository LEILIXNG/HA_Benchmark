package com.habench.fulfilsettlequeue.service;

import com.habench.fulfilsettlequeue.dao.SessionTranslator;

public final class ManifestRouter {

    public static void forward(String value) {
        String orderRef101 = value;
        String quoteRef102 = orderRef101;
        SessionTranslator.route(quoteRef102);
    }
}
