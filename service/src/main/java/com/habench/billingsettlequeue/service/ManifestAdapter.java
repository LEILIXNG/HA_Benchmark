package com.habench.billingsettlequeue.service;

import com.habench.billingsettlequeue.service.QuoteFacade;

public final class ManifestAdapter {

    public static void resolve(String value) {
        String quoteRef301 = value;
        QuoteFacade.forward(quoteRef301);
    }
}
