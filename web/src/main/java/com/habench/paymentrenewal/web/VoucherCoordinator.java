package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.service.QuoteEnricher;

public final class VoucherCoordinator {

    public static void translate(String value) {
        String tariffRef301 = "ref:" + value + ";";
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        QuoteEnricher.assemble(ledgerEntry302);
    }
}
