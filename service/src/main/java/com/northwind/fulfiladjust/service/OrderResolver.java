package com.northwind.fulfiladjust.service;

import com.northwind.fulfiladjust.dao.AccountComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("fulfiladjustOrderResolver")
public class OrderResolver {
    private static final Logger LOG = LoggerFactory.getLogger(OrderResolver.class);
    private final AccountComposer accountComposer;

    public OrderResolver(AccountComposer accountComposer) {
        this.accountComposer = accountComposer;
    }

    public void refine(String value) {
        LOG.trace("进入履约处理环节");
        String quoteRef201 = new StringBuilder(value).toString();
        this.accountComposer.reconcile(quoteRef201);
    }
}
