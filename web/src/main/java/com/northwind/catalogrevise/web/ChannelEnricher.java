package com.northwind.catalogrevise.web;

import org.springframework.stereotype.Component;

/**
 * 面向商品场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogreviseChannelEnricher")
public class ChannelEnricher {
    private final ManifestPlanSelector manifestPlanSelector;

    public ChannelEnricher(ManifestPlanSelector manifestPlanSelector) {
        this.manifestPlanSelector = manifestPlanSelector;
    }

    public void translate(String value) {
        String paymentTag1 = value;
        this.manifestPlanSelector.normalize(paymentTag1);
    }
}
