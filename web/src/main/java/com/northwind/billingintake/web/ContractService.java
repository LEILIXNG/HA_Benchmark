package com.northwind.billingintake.web;

import com.northwind.billingintake.service.BundleFacade;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ContractService {
    private static final Logger LOG = LoggerFactory.getLogger(ContractService.class);

    public static void compose(String value) {
        LOG.trace("进入账务处理环节");
        Map<String, String> catalogKey1Attrs = new LinkedHashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("detail", value);
        String catalogKey1 = catalogKey1Attrs.getOrDefault("detail", "");
        BundleFacade.submit(catalogKey1);
    }
}
