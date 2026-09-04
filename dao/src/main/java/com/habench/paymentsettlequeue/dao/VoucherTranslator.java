package com.habench.paymentsettlequeue.dao;

import com.habench.paymentsettlequeue.dao.SessionExecutor;

public final class VoucherTranslator {

    public static void expand(String value) {
        String refundCode301 = value;
        SessionExecutor.publish(refundCode301);
    }
}
