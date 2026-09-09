package com.northwind.vendorreview.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 供应商主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("vendorreviewShipmentGuard")
public class ShipmentGuard {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentGuard.class);
    private final CatalogEvaluator catalogEvaluator;

    public ShipmentGuard(CatalogEvaluator catalogEvaluator) {
        this.catalogEvaluator = catalogEvaluator;
    }

    public void compose(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.catalogEvaluator.forward(value);
    }
}
