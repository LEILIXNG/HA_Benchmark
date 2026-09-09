package com.northwind.shippingdispatch.dao;

import com.northwind.platform.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向发运场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("shippingdispatchOrderPolicy")
public class OrderPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(OrderPolicy.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final BundleEvaluator bundleEvaluator;

    public OrderPolicy(BundleEvaluator bundleEvaluator) {
        this.bundleEvaluator = bundleEvaluator;
    }

    public void stage(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        this.bundleEvaluator.collect(value);
    }
}
