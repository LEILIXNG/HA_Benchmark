package com.habench.reportbind.web;

import com.habench.reportbind.service.QuoteRouter;

public final class BatchFacade {

    public static void compose(String value) {
        String batchTag101 = value;
        QuoteRouter.normalize(batchTag101);
    }
}
