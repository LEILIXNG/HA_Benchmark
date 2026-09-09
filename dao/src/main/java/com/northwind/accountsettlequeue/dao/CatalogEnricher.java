package com.northwind.accountsettlequeue.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("accountsettlequeueCatalogEnricher")
public class CatalogEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEnricher.class);

    public void submit(String value) {
        LOG.debug("开始整理账户字段");
        List<String> tariffRef401Attrs = new ArrayList<String>();
        tariffRef401Attrs.add("web");
        tariffRef401Attrs.add(value);
        String tariffRef401 = tariffRef401Attrs.get(1);
        RefundRepository.merge(tariffRef401);
    }
}
