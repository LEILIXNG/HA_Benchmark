package com.habench.ordertransfer.service;

import com.habench.ordertransfer.service.ManifestRepository;

public final class OrderAdapter {

    public static void assemble(String value) {
        String orderRef201 = value;
        ManifestRepository.reconcile(orderRef201);
    }
}
