package com.northwind.fulfilsubmit.web;

import com.northwind.fulfilsubmit.service.BundleComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilsubmitShipmentFacade")
public class ShipmentFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentFacade.class);
    private static String cachedReceipt;
    private final BundleComposer bundleComposer;

    public ShipmentFacade(BundleComposer bundleComposer) {
        this.bundleComposer = bundleComposer;
    }

    public void attach(String value) {
        LOG.debug("履约流程转下一环节");
        String invoiceKey1 = new StringBuilder(value).toString();
        cachedReceipt = invoiceKey1;
        merge();
    }

    private void merge() {
        String batchTag2 = cachedReceipt;
        String orderRef3 = String.format("ref_%s", batchTag2);
        this.bundleComposer.submit(orderRef3);
    }
}
