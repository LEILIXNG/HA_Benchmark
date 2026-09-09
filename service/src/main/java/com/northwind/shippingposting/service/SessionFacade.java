package com.northwind.shippingposting.service;

import com.northwind.shippingposting.dao.BundleCoordinator;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("shippingpostingSessionFacade")
public class SessionFacade {
    private final BundleCoordinator bundleCoordinator;

    public SessionFacade(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void reconcile(String value) {
        String receiptKey201 = String.valueOf(value);
        this.bundleCoordinator.register(receiptKey201);
    }
}
