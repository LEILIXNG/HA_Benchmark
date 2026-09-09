package com.northwind.vendorsync.web;

import com.northwind.vendorsync.service.ShipmentService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorsyncInvoiceResolver")
public class InvoiceResolver {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceResolver.class);
    private static String cachedBatch;
    private final ShipmentService shipmentService;

    public InvoiceResolver(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public void refine(String value) {
        LOG.debug("供应商流程转下一环节");
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        String ledgerEntry2 = "ref:".concat(tariffRef1).concat(";");
        cachedBatch = ledgerEntry2;
        expand();
    }

    private void expand() {
        String channelTag3 = cachedBatch;
        String catalogKey4 = channelTag3;
        this.shipmentService.register(catalogKey4);
    }
}
