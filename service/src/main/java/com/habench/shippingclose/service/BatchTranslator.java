package com.habench.shippingclose.service;

import com.habench.shippingclose.service.SessionRegistry;

public final class BatchTranslator {

    public static void assemble(String value) {
        String batchTag301 = "ref:" + value + ";";
        SessionRegistry.merge(batchTag301);
    }
}
