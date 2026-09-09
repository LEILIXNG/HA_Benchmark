package com.northwind.pricingsplit.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("pricingsplitCatalogFacade")
public class CatalogFacade {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogFacade.class);

    public void normalize(String value) {
        LOG.debug("开始整理定价字段");
        List<String> batchTag101Attrs = new ArrayList<String>();
        batchTag101Attrs.add("web");
        batchTag101Attrs.add(value);
        String batchTag101 = batchTag101Attrs.get(1);
        BundleEnricher.normalize(batchTag101);
    }
}
