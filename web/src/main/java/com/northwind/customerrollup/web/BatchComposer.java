package com.northwind.customerrollup.web;

import com.northwind.customerrollup.service.ContractCollector;
import org.springframework.stereotype.Component;

/**
 * 面向客户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("customerrollupBatchComposer")
public class BatchComposer {
    private String pendingAccount;
    private final ContractCollector contractCollector;

    public BatchComposer(ContractCollector contractCollector) {
        this.contractCollector = contractCollector;
    }

    public void prepare(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String catalogKey1 = String.valueOf(value);
        this.pendingAccount = catalogKey1;
        stage();
    }

    private void stage() {
        String receiptKey2 = this.pendingAccount;
        String accountRef3 = String.valueOf(receiptKey2);
        this.contractCollector.reconcile(accountRef3);
    }
}
