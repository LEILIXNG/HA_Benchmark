package com.northwind.reportrollup.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportrollupManifestPolicyStandard")
public class ManifestPolicyStandard implements ManifestPolicy {
    private final TariffNormalizer tariffNormalizer;

    public ManifestPolicyStandard(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    @Override
    public void handle(String value) {
        this.tariffNormalizer.prepare(value);
    }
}
