package com.northwind.orderbind.dao;

import org.springframework.stereotype.Repository;

/**
 * 订单的默认处理策略。
 */
@Repository("orderbindCatalogPolicyStandard")
public class CatalogPolicyStandard implements CatalogPolicy {
    private final ManifestNormalizer manifestNormalizer;

    public CatalogPolicyStandard(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    @Override
    public void handle(String value) {
        this.manifestNormalizer.collect(value);
    }
}
