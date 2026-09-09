package com.northwind.fulfilverify.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilverifyQuoteFacade")
public class QuoteFacade {
    private static String cachedBundle;
    private final ShipmentPlanSelector shipmentPlanSelector;

    public QuoteFacade(ShipmentPlanSelector shipmentPlanSelector) {
        this.shipmentPlanSelector = shipmentPlanSelector;
    }

    public void submit(String value) {
        String channelTag1 = value;
        String catalogKey2 = String.valueOf(channelTag1);
        cachedBundle = catalogKey2;
        prepare();
    }

    private void prepare() {
        String receiptKey3 = cachedBundle;
        StringBuilder accountRef4Buffer = new StringBuilder("ref:");
        accountRef4Buffer.append(receiptKey3).append(";");
        String accountRef4 = accountRef4Buffer.toString();
        List<String> voucherRef5Attrs = new ArrayList<String>();
        voucherRef5Attrs.add("web");
        voucherRef5Attrs.add(accountRef4);
        String voucherRef5 = voucherRef5Attrs.get(1);
        this.shipmentPlanSelector.expand(voucherRef5);
    }
}
