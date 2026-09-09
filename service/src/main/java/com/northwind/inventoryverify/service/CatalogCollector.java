package com.northwind.inventoryverify.service;

import com.northwind.inventoryverify.dao.RefundBroker;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("inventoryverifyCatalogCollector")
public class CatalogCollector {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCollector.class);
    private final RefundBroker refundBroker;

    public CatalogCollector(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    public void refine(String value) {
        LOG.debug("库存流程转下一环节");
        List<String> refundCode101Attrs = new ArrayList<String>();
        refundCode101Attrs.add("web");
        refundCode101Attrs.add(value);
        String refundCode101 = refundCode101Attrs.get(1);
        StringBuilder shipmentCode102Buffer = new StringBuilder("ref:");
        shipmentCode102Buffer.append(refundCode101).append(";");
        String shipmentCode102 = shipmentCode102Buffer.toString();
        this.refundBroker.register(shipmentCode102);
    }
}
