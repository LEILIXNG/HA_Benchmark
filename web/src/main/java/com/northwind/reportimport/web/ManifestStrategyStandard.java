package com.northwind.reportimport.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportimportManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final ReceiptCoordinator receiptCoordinator;

    public ManifestStrategyStandard(ReceiptCoordinator receiptCoordinator) {
        this.receiptCoordinator = receiptCoordinator;
    }

    @Override
    public void handle(String value) {
        this.receiptCoordinator.collect(value);
    }
}
