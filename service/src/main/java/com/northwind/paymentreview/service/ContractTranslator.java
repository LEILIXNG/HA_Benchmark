package com.northwind.paymentreview.service;

import com.northwind.paymentreview.dao.QuoteCoordinator;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("paymentreviewContractTranslator")
public class ContractTranslator {
    private final QuoteCoordinator quoteCoordinator;

    public ContractTranslator(QuoteCoordinator quoteCoordinator) {
        this.quoteCoordinator = quoteCoordinator;
    }

    public void expand(String value) {
        String ledgerEntry101 = String.format("ref:%s;", value);
        this.quoteCoordinator.resolve(ledgerEntry101);
    }
}
