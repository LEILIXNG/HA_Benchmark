package com.habench.fulfilarchive.dao;

import com.habench.fulfilarchive.dao.InvoiceRepository;

public final class ShipmentNormalizer {

    public static void merge(String value) {
        InvoiceRepository.attach(value);
    }
}
