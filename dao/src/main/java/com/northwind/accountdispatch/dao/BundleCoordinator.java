package com.northwind.accountdispatch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("accountdispatchBundleCoordinator")
public class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);
    private final LedgerCoordinator ledgerCoordinator;

    public BundleCoordinator(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    public void prepare(String value) {
        LOG.trace("进入账户处理环节");
        StringBuilder shipmentCode301Buffer = new StringBuilder("ref:");
        shipmentCode301Buffer.append(value).append(";");
        String shipmentCode301 = shipmentCode301Buffer.toString();
        this.ledgerCoordinator.submit(shipmentCode301);
    }
}
