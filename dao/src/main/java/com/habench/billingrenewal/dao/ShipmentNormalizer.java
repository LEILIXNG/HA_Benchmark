package com.habench.billingrenewal.dao;

import com.habench.billingrenewal.dao.InvoiceRepository;

public final class ShipmentNormalizer {

    public static void merge(String value) {
        InvoiceRepository.attach(value);
    }
}
