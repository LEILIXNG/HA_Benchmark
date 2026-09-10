package com.northwind.customerdispatch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("customerdispatchQuoteCoordinator")
public class QuoteCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteCoordinator.class);
    private String pendingLedger;
    private final LedgerExecutor ledgerExecutor;

    public QuoteCoordinator(LedgerExecutor ledgerExecutor) {
        this.ledgerExecutor = ledgerExecutor;
    }

    public void expand(String value) {
        LOG.debug("接收到一次客户处理请求");
        this.register(value);
    }

    private void register(String value) {
        String batchTag301 = new StringBuilder(value).toString();
        this.pendingLedger = batchTag301;
        prepare();
    }

    private void prepare() {
        String orderRef302 = this.pendingLedger;
        StringBuilder quoteRef303Buffer = new StringBuilder("ref_");
        quoteRef303Buffer.append(orderRef302);
        String quoteRef303 = quoteRef303Buffer.toString();
        String tariffRef304 = quoteRef303;
        this.ledgerExecutor.attach(tariffRef304);
    }
}
