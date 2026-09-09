package com.northwind.fulfilcapture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ContractCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCoordinator.class);

    public static void route(String value) {
        LOG.trace("进入履约处理环节");
        String shipmentCode301 = String.valueOf(value);
        BundlePlanSelector.route(shipmentCode301);
    }
}
