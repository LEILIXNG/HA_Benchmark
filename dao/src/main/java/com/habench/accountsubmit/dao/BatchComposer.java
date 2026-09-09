package com.habench.accountsubmit.dao;

import com.habench.accountsubmit.dao.SessionFetcher;

public final class BatchComposer {

    public static void compose(String value) {
        String batchTag201 = value;
        String orderRef202 = "ref:" + batchTag201 + ";";
        SessionFetcher.compose(orderRef202);
    }
}
