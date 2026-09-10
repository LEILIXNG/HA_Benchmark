package com.northwind.fulfilverify.service;

import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilverifyCatalogFacade")
public class CatalogFacade {
    private final BundleRepository bundleRepository;

    public CatalogFacade(BundleRepository bundleRepository) {
        this.bundleRepository = bundleRepository;
    }

    public void reconcile(String value) {
        String paymentTag201 = "ref_" + value;
        this.bundleRepository.reconcile(paymentTag201);
    }
}
