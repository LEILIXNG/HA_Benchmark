package com.northwind.inventorysettlequeue.service;

import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("inventorysettlequeueLedgerService")
public class LedgerService {
    private final AccountFacade accountFacade;

    public LedgerService(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    public void refine(String value) {
        String orderRef201 = String.valueOf(value);
        String quoteRef202 = "ref_" + orderRef201;
        this.accountFacade.prepare(quoteRef202);
    }
}
