package com.northwind.pricingsplit.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricingsplitBatchGuard")
public class BatchGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final CatalogFacade catalogFacade;

    public BatchGuard(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    public void stage(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.catalogFacade.normalize(value);
    }
}
