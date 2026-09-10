package com.northwind.inventorybatch.web;

import com.northwind.inventorybatch.service.BundleCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("inventorybatchTariffAdapter")
public class TariffAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAdapter.class);
    private final BundleCollector bundleCollector;

    public TariffAdapter(BundleCollector bundleCollector) {
        this.bundleCollector = bundleCollector;
    }

    public void stage(String value) {
        LOG.debug("开始整理库存字段");
        StringBuilder orderRef101Buffer = new StringBuilder("ref_");
        orderRef101Buffer.append(value);
        String orderRef101 = orderRef101Buffer.toString();
        this.bundleCollector.register(orderRef101);
    }
}
