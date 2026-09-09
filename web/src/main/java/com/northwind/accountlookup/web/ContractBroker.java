package com.northwind.accountlookup.web;

import com.northwind.accountlookup.service.QuoteAssembler;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountlookupContractBroker")
public class ContractBroker {
    private final QuoteAssembler quoteAssembler;

    public ContractBroker(QuoteAssembler quoteAssembler) {
        this.quoteAssembler = quoteAssembler;
    }

    public void collect(String value) {
        String quoteRef1 = new StringBuilder(value).toString();
        this.quoteAssembler.publish(quoteRef1);
    }
}
