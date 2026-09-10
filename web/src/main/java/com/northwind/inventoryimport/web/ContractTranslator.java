package com.northwind.inventoryimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("inventoryimportContractTranslator")
public class ContractTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractTranslator.class);
    private final BundleRuleSelector bundleRuleSelector;

    public ContractTranslator(BundleRuleSelector bundleRuleSelector) {
        this.bundleRuleSelector = bundleRuleSelector;
    }

    public void resolve(String value) {
        LOG.debug("库存流程转下一环节");
        String tariffRef101 = "ref_" + value;
        this.bundleRuleSelector.attach(tariffRef101);
    }
}
