package com.habench.inventorydraft.service;

import com.habench.inventorydraft.service.QuoteScreen;

public final class AccountCollector {

    public static void attach(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        QuoteScreen.translate(shipmentCode201);
    }
}
