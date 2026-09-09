package com.northwind.inventoryapprove.web;

import org.springframework.stereotype.Component;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventoryapproveAccountComposer")
public class AccountComposer {
    private final ContractTranslator contractTranslator;

    public AccountComposer(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    public void dispatch(String value) {
        String receiptKey101 = value;
        this.contractTranslator.compose(receiptKey101);
    }
}
