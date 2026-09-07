package com.habench.accountrenewal.service;

import com.habench.accountrenewal.dao.ManifestBuilder;

public final class TariffAssembler {

    public static void submit(String value) {
        String receiptKey201 = "ref:" + value + ";";
        ManifestBuilder.assemble(receiptKey201);
    }
}
