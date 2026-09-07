package com.habench.catalogmerge.web;

import com.habench.catalogmerge.service.RefundFacade;

public final class BatchAdapter {

    public static void compose(String value) {
        String orderRef101 = value;
        RefundFacade.translate(orderRef101);
    }
}
