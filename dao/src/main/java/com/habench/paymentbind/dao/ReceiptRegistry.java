package com.habench.paymentbind.dao;

import com.habench.paymentbind.dao.ChannelAssembler;

public final class ReceiptRegistry {

    public static void prepare(String value) {
        String receiptKey401 = value;
        ChannelAssembler.prepare(receiptKey401);
    }
}
