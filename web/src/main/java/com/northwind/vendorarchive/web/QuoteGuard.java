package com.northwind.vendorarchive.web;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorarchiveQuoteGuard")
public class QuoteGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final PaymentEvaluator paymentEvaluator;

    public QuoteGuard(PaymentEvaluator paymentEvaluator) {
        this.paymentEvaluator = paymentEvaluator;
    }

    public void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.paymentEvaluator.expand(value);
    }
}
