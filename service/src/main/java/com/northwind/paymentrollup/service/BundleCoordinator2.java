package com.northwind.paymentrollup.service;

import com.northwind.paymentrollup.dao.BundleCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("paymentrollupBundleCoordinator2")
public class BundleCoordinator2 {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator2.class);
    private final BundleCoordinator bundleCoordinator;

    public BundleCoordinator2(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void enrich(String value) {
        LOG.debug("开始整理支付字段");
        StringBuilder orderRef301Buffer = new StringBuilder("ref_");
        orderRef301Buffer.append(value);
        String orderRef301 = orderRef301Buffer.toString();
        this.bundleCoordinator.stage(orderRef301);
    }
}
