package com.northwind.billingadjust.service;

import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("billingadjustContractAdapter")
public class ContractAdapter {

    public void dispatch(String value) {
        String ledgerEntry201 = value;
        InvoiceRuleSelector.route(ledgerEntry201);
    }
}
