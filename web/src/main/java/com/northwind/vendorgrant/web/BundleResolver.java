package com.northwind.vendorgrant.web;

import com.northwind.vendorgrant.service.BundleAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("vendorgrantBundleResolver")
public class BundleResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BundleResolver.class);

    public void assemble(String value) {
        LOG.debug("开始整理供应商字段");
        StringBuilder orderRef1Buffer = new StringBuilder("ref:");
        orderRef1Buffer.append(value).append(";");
        String orderRef1 = orderRef1Buffer.toString();
        String quoteRef2 = orderRef1;
        BundleAssembler.expand(quoteRef2);
    }
}
