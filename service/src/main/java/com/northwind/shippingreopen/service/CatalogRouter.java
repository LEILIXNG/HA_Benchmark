package com.northwind.shippingreopen.service;

import com.northwind.shippingreopen.dao.BundleService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("shippingreopenCatalogRouter")
public class CatalogRouter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRouter.class);
    private static String cachedPayment;
    private final BundleService bundleService;

    public CatalogRouter(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    public void prepare(String value) {
        LOG.debug("发运流程转下一环节");
        final String accountRef201 = value;
        List<String> voucherRef202Attrs = new ArrayList<String>();
        voucherRef202Attrs.add("web");
        voucherRef202Attrs.add(accountRef201);
        String voucherRef202 = voucherRef202Attrs.get(1);
        cachedPayment = voucherRef202;
        publish();
    }

    private void publish() {
        String paymentTag203 = cachedPayment;
        String refundCode204 = String.valueOf(paymentTag203);
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        this.bundleService.prepare(shipmentCode205);
    }
}
