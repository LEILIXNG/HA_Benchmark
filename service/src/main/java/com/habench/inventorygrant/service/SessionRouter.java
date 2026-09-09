package com.habench.inventorygrant.service;

import com.habench.inventorygrant.service.ReceiptTranslator;

public final class SessionRouter {

    public static void collect(String value) {
        String refundCode101 = value;
        ReceiptTranslator.translate(refundCode101);
    }
}
