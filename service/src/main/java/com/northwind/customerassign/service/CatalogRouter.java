package com.northwind.customerassign.service;

import com.northwind.customerassign.dao.ContractRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("customerassignCatalogRouter")
public class CatalogRouter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRouter.class);
    private final ContractRegistry contractRegistry;

    public CatalogRouter(ContractRegistry contractRegistry) {
        this.contractRegistry = contractRegistry;
    }

    public void submit(String value) {
        LOG.debug("接收到一次客户处理请求");
        Map<String, String> invoiceKey101Attrs = new LinkedHashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("detail", value);
        String invoiceKey101 = invoiceKey101Attrs.getOrDefault("detail", "");
        Map<String, String> batchTag102Attrs = new LinkedHashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("remark", invoiceKey101);
        String batchTag102 = batchTag102Attrs.getOrDefault("remark", "");
        this.contractRegistry.translate(batchTag102);
    }
}
