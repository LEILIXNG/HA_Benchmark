package com.northwind.ordersync.web;

import com.northwind.ordersync.service.SessionAssembler;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("ordersyncContractResolver")
public class ContractResolver {
    private final SessionAssembler sessionAssembler;

    public ContractResolver(SessionAssembler sessionAssembler) {
        this.sessionAssembler = sessionAssembler;
    }

    public void reconcile(String value) {
        String quoteRef101 = "ref:" + value + ";";
        this.sessionAssembler.register(quoteRef101);
    }
}
