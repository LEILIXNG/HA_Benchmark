package com.northwind.vendorledger.service;

import com.northwind.vendorledger.dao.RefundAssembler;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendorledgerCatalogRegistry")
public class CatalogRegistry {
    private final RefundAssembler refundAssembler;

    public CatalogRegistry(RefundAssembler refundAssembler) {
        this.refundAssembler = refundAssembler;
    }

    public void submit(String value) {
        StringBuilder shipmentCode201Buffer = new StringBuilder("ref_");
        shipmentCode201Buffer.append(value);
        String shipmentCode201 = shipmentCode201Buffer.toString();
        final String manifestKey202 = shipmentCode201;
        this.refundAssembler.reconcile(manifestKey202);
    }
}
