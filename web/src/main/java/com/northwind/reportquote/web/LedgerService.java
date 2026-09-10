package com.northwind.reportquote.web;

import com.northwind.reportquote.service.ShipmentCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportquoteLedgerService")
public class LedgerService {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerService.class);
    private final ShipmentCollector shipmentCollector;

    public LedgerService(ShipmentCollector shipmentCollector) {
        this.shipmentCollector = shipmentCollector;
    }

    public void register(String value) {
        LOG.debug("开始整理报表字段");
        String catalogKey1 = "ref_" + value;
        this.shipmentCollector.refine(catalogKey1);
    }
}
