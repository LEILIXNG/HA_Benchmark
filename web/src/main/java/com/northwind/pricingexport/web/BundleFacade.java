package com.northwind.pricingexport.web;

import com.northwind.pricingexport.service.OrderFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingexportBundleFacade")
public class BundleFacade {
    private static final Logger LOG = LoggerFactory.getLogger(BundleFacade.class);

    public void translate(String value) {
        LOG.trace("进入定价处理环节");
        final String receiptKey201 = value;
        String accountRef202 = new StringBuilder(receiptKey201).toString();
        OrderFacade.refine(accountRef202);
    }
}
