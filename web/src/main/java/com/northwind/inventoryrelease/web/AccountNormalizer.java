package com.northwind.inventoryrelease.web;

import com.northwind.inventoryrelease.service.InvoiceResolver;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryreleaseAccountNormalizer")
public class AccountNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountNormalizer.class);

    public void stage(String value) {
        LOG.debug("开始整理库存字段");
        String quoteRef1 = value;
        List<String> tariffRef2Attrs = new ArrayList<String>();
        tariffRef2Attrs.add("web");
        tariffRef2Attrs.add(quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get(1);
        InvoiceResolver.normalize(tariffRef2);
    }
}
