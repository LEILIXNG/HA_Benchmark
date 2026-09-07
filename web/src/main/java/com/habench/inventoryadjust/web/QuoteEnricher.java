package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.service.SessionEnricher;

public final class QuoteEnricher {

    public static void submit(String value) {
        String shipmentCode1 = value;
        SessionEnricher.enrich(shipmentCode1);
    }
}
