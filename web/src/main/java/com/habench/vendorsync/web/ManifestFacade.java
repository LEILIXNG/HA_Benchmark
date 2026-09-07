package com.habench.vendorsync.web;

import com.habench.vendorsync.service.BatchNormalizer;

public final class ManifestFacade {

    public static void translate(String value) {
        String tariffRef1 = "ref:" + value + ";";
        BatchNormalizer.stage(tariffRef1);
    }
}
