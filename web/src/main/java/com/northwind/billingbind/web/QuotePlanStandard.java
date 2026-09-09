package com.northwind.billingbind.web;

import org.springframework.stereotype.Component;

/**
 * 账务的默认处理策略。
 */
@Component("billingbindQuotePlanStandard")
public class QuotePlanStandard implements QuotePlan {
    private final ManifestCoordinator manifestCoordinator;

    public QuotePlanStandard(ManifestCoordinator manifestCoordinator) {
        this.manifestCoordinator = manifestCoordinator;
    }

    @Override
    public void handle(String value) {
        this.manifestCoordinator.enrich(value);
    }
}
