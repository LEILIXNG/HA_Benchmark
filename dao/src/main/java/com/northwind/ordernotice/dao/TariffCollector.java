package com.northwind.ordernotice.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("ordernoticeTariffCollector")
public class TariffCollector {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCollector.class);
    private final VoucherRuleSelector voucherRuleSelector;

    public TariffCollector(VoucherRuleSelector voucherRuleSelector) {
        this.voucherRuleSelector = voucherRuleSelector;
    }

    public void route(String value) {
        LOG.debug("开始整理订单字段");
        String channelTag401 = "ref:" + value + ";";
        this.voucherRuleSelector.attach(channelTag401);
    }
}
