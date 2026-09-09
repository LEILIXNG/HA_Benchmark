package com.northwind.reportadjust.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportadjustManifestPolicyStandard")
public class ManifestPolicyStandard implements ManifestPolicy {
    private final OrderNormalizer orderNormalizer;

    public ManifestPolicyStandard(OrderNormalizer orderNormalizer) {
        this.orderNormalizer = orderNormalizer;
    }

    @Override
    public void handle(String value) {
        this.orderNormalizer.compose(value);
    }
}
