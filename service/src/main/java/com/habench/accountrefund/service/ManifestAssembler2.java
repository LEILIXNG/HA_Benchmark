package com.habench.accountrefund.service;

import com.habench.accountrefund.dao.ManifestAssembler;

public final class ManifestAssembler2 {

    public static void translate(String value) {
        String catalogKey201 = "ref:" + value + ";";
        ManifestAssembler.enrich(catalogKey201);
    }
}
