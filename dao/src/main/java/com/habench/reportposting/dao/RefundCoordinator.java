package com.habench.reportposting.dao;

import com.habench.reportposting.dao.ManifestRepository;

public final class RefundCoordinator {

    public static void route(String value) {
        String quoteRef401 = "ref:" + value + ";";
        ManifestRepository.submit(quoteRef401);
    }
}
