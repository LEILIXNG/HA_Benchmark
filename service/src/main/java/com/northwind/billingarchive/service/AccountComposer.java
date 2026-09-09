package com.northwind.billingarchive.service;

import com.northwind.billingarchive.dao.AccountEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("billingarchiveAccountComposer")
public class AccountComposer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountComposer.class);
    private final AccountEnricher accountEnricher;

    public AccountComposer(AccountEnricher accountEnricher) {
        this.accountEnricher = accountEnricher;
    }

    public void merge(String value) {
        LOG.debug("账务流程转下一环节");
        this.accountEnricher.forward(value);
    }
}
