package com.northwind.billingsubmit.web;

import com.northwind.billingsubmit.service.ShipmentEnricher;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingsubmitManifestFacade")
public class ManifestFacade {
    private final ShipmentEnricher shipmentEnricher;

    public ManifestFacade(ShipmentEnricher shipmentEnricher) {
        this.shipmentEnricher = shipmentEnricher;
    }

    public void prepare(String value) {
        List<String> batchTag101Attrs = new ArrayList<String>();
        batchTag101Attrs.add("web");
        batchTag101Attrs.add(value);
        String batchTag101 = batchTag101Attrs.get(1);
        String orderRef102 = batchTag101;
        this.shipmentEnricher.enrich(orderRef102);
    }
}
