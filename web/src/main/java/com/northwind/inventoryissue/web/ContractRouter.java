package com.northwind.inventoryissue.web;

import com.northwind.inventoryissue.service.CatalogEnricher;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventoryissueContractRouter")
public class ContractRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRouter.class);
    private final CatalogEnricher catalogEnricher;

    public ContractRouter(CatalogEnricher catalogEnricher) {
        this.catalogEnricher = catalogEnricher;
    }

    public void resolve(String value) {
        LOG.debug("开始整理库存字段");
        List<String> invoiceKey1Attrs = new ArrayList<String>();
        invoiceKey1Attrs.add("web");
        invoiceKey1Attrs.add(value);
        String invoiceKey1 = invoiceKey1Attrs.get(1);
        this.catalogEnricher.reconcile(invoiceKey1);
    }
}
