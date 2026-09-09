package com.northwind.customerexport.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class LedgerScreen {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerScreen.class);
    private static final List<String> PERMITTED =
            Collections.unmodifiableList(Arrays.asList("status", "version", "uptime"));

    public static void route(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        BatchPlanSelector.resolve(value);
    }
}
