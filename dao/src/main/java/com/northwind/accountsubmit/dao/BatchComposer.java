package com.northwind.accountsubmit.dao;

import org.springframework.stereotype.Repository;

/**
 * 账户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("accountsubmitBatchComposer")
public class BatchComposer {
    private final SessionFetcher sessionFetcher;

    public BatchComposer(SessionFetcher sessionFetcher) {
        this.sessionFetcher = sessionFetcher;
    }

    public void compose(String value) {
        final String batchTag201 = value;
        String orderRef202 = "ref:" + batchTag201 + ";";
        this.sessionFetcher.compose(orderRef202);
    }
}
