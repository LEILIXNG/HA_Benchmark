package com.northwind.billingsplit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingsplitAccountService")
public class AccountService {
    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
    private String pendingChannel;
    private final TariffStrategySelector tariffStrategySelector;

    public AccountService(TariffStrategySelector tariffStrategySelector) {
        this.tariffStrategySelector = tariffStrategySelector;
    }

    public void register(String value) {
        LOG.trace("进入账务处理环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        final String quoteRef201 = value;
        this.pendingChannel = quoteRef201;
        attach();
    }

    private void attach() {
        String tariffRef202 = this.pendingChannel;
        StringBuilder ledgerEntry203Buffer = new StringBuilder("ref_");
        ledgerEntry203Buffer.append(tariffRef202);
        String ledgerEntry203 = ledgerEntry203Buffer.toString();
        this.tariffStrategySelector.forward(ledgerEntry203);
    }
}
