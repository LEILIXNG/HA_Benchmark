package com.northwind.inventoryissue.dao;

import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("inventoryissueManifestEnricher")
public class ManifestEnricher {
    private final BatchRouter batchRouter;

    public ManifestEnricher(BatchRouter batchRouter) {
        this.batchRouter = batchRouter;
    }

    public void translate(String value) {
        String invoiceKey301 = "ref_" + value;
        this.batchRouter.assemble(invoiceKey301);
    }
}
