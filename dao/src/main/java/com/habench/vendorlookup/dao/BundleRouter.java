package com.habench.vendorlookup.dao;

import com.habench.vendorlookup.dao.ManifestCoordinator;

public final class BundleRouter {

    public static void submit(String value) {
        String accountRef301 = value;
        ManifestCoordinator.collect(accountRef301);
    }
}
