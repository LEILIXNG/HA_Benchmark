package com.northwind.orderrefund.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("orderrefundBundleFacade")
public class BundleFacade {
    private final BatchPlanSelector batchPlanSelector;

    public BundleFacade(BatchPlanSelector batchPlanSelector) {
        this.batchPlanSelector = batchPlanSelector;
    }

    public void forward(String value) {
        String manifestKey201 = new StringBuilder(value).toString();
        List<String> invoiceKey202Attrs = new ArrayList<String>();
        invoiceKey202Attrs.add("web");
        invoiceKey202Attrs.add(manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get(1);
        this.batchPlanSelector.resolve(invoiceKey202);
    }
}
