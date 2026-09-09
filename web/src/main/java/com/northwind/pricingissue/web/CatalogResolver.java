package com.northwind.pricingissue.web;

import com.northwind.pricingissue.service.LedgerNormalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingissueCatalogResolver")
public class CatalogResolver {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogResolver.class);
    private final LedgerNormalizer ledgerNormalizer;

    public CatalogResolver(LedgerNormalizer ledgerNormalizer) {
        this.ledgerNormalizer = ledgerNormalizer;
    }

    public void dispatch(String value) {
        LOG.trace("进入定价处理环节");
        Map<String, String> tariffRef1Attrs = new LinkedHashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.getOrDefault("detail", "");
        List<String> ledgerEntry2Attrs = new ArrayList<String>();
        ledgerEntry2Attrs.add("web");
        ledgerEntry2Attrs.add(tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get(1);
        this.ledgerNormalizer.reconcile(ledgerEntry2);
    }
}
