package com.habench.catalogreopen.web;

import com.habench.catalogreopen.web.ReceiptService;

public final class CatalogCoordinator {

    public static void forward(String value) {
        String ledgerEntry1 = value;
        ReceiptService.translate(ledgerEntry1);
    }
}
