package com.northwind.inventoryrevise.service;

import com.northwind.inventoryrevise.dao.SessionNormalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("inventoryreviseBundleBuilder")
public class BundleBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBuilder.class);

    public void merge(String value) {
        LOG.trace("进入库存处理环节");
        String shipmentCode101 = String.valueOf(value);
        SessionNormalizer.stage(shipmentCode101);
    }
}
