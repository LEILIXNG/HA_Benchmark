package com.northwind.pricingtransfer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingtransferContractNormalizer")
public class ContractNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractNormalizer.class);
    private static String cachedAccount;
    private final OrderRuleSelector orderRuleSelector;

    public ContractNormalizer(OrderRuleSelector orderRuleSelector) {
        this.orderRuleSelector = orderRuleSelector;
    }

    public void submit(String value) {
        LOG.debug("开始整理定价字段");
        final String orderRef1 = value;
        String quoteRef2 = new StringBuilder(orderRef1).toString();
        cachedAccount = quoteRef2;
        attach();
    }

    private void attach() {
        String tariffRef3 = cachedAccount;
        String ledgerEntry4 = String.valueOf(tariffRef3);
        this.orderRuleSelector.dispatch(ledgerEntry4);
    }
}
