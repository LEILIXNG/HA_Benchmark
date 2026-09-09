package com.northwind.pricingintake.web;

import com.northwind.pricingintake.service.QuoteNormalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherResolver {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherResolver.class);

    public static void collect(String value) {
        LOG.trace("进入定价处理环节");
        String refundCode101 = value;
        QuoteNormalizer.merge(refundCode101);
    }
}
