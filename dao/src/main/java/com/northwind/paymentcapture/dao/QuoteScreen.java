package com.northwind.paymentcapture.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentcaptureQuoteScreen")
public class QuoteScreen {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteScreen.class);
    private final BundleEvaluator bundleEvaluator;

    public QuoteScreen(BundleEvaluator bundleEvaluator) {
        this.bundleEvaluator = bundleEvaluator;
    }

    public void submit(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value;
        if (cleaned.indexOf("T(") >= 0) {
            cleaned = cleaned.replace("T(", "");
        }
        this.bundleEvaluator.publish(cleaned);
    }
}
