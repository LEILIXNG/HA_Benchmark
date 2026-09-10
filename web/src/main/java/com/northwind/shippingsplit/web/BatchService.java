package com.northwind.shippingsplit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingsplitBatchService")
public class BatchService {
    private static final Logger LOG = LoggerFactory.getLogger(BatchService.class);
    private String pendingContract;
    private final LedgerStrategySelector ledgerStrategySelector;

    public BatchService(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次发运处理请求");
        this.normalize(value);
    }

    private void normalize(String value) {
        String orderRef1 = String.format("ref_%s", value);
        this.pendingContract = orderRef1;
        expand();
    }

    private void expand() {
        String quoteRef2 = this.pendingContract;
        String tariffRef3 = quoteRef2;
        this.ledgerStrategySelector.forward(tariffRef3);
    }
}
