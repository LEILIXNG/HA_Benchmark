package com.northwind.vendordraft.service;

import com.northwind.vendordraft.dao.LedgerBroker;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendordraftPaymentEnricher")
public class PaymentEnricher {
    private final LedgerBroker ledgerBroker;

    public PaymentEnricher(LedgerBroker ledgerBroker) {
        this.ledgerBroker = ledgerBroker;
    }

    public void compose(String value) {
        String orderRef101 = "ref_" + value;
        String quoteRef102 = String.valueOf(orderRef101);
        this.ledgerBroker.assemble(quoteRef102);
    }
}
