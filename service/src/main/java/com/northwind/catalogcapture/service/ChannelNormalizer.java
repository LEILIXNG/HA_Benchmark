package com.northwind.catalogcapture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("catalogcaptureChannelNormalizer")
public class ChannelNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelNormalizer.class);
    private final TariffRuleSelector tariffRuleSelector;

    public ChannelNormalizer(TariffRuleSelector tariffRuleSelector) {
        this.tariffRuleSelector = tariffRuleSelector;
    }

    public void collect(String value) {
        LOG.debug("商品流程转下一环节");
        String accountRef101 = "ref:".concat(value).concat(";");
        this.tariffRuleSelector.attach(accountRef101);
    }
}
