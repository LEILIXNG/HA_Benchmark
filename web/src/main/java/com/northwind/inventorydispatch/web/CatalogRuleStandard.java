package com.northwind.inventorydispatch.web;

/**
 * 库存的默认处理策略。
 */
public final class CatalogRuleStandard implements CatalogRule {

    @Override
    public void handle(String value) {
        ChannelNormalizer.refine(value);
    }
}
