package com.habench.vendorverify.service;

import com.habench.vendorverify.service.ManifestRepository;

public final class BundleAssembler {

    public static void prepare(String value) {
        String manifestKey401 = "ref:" + value + ";";
        ManifestRepository.merge(manifestKey401);
    }
}
