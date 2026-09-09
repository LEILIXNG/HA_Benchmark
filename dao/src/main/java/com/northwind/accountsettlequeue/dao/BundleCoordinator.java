package com.northwind.accountsettlequeue.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("accountsettlequeueBundleCoordinator")
public class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);
    private final AccountStrategySelector accountStrategySelector;

    public BundleCoordinator(AccountStrategySelector accountStrategySelector) {
        this.accountStrategySelector = accountStrategySelector;
    }

    public void publish(String value) {
        LOG.debug("开始整理账户字段");
        String accountRef301 = String.valueOf(value);
        String voucherRef302 = String.format("ref:%s;", accountRef301);
        this.accountStrategySelector.enrich(voucherRef302);
    }
}
