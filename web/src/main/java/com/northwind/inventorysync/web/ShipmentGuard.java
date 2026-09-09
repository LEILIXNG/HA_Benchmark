package com.northwind.inventorysync.web;

import com.northwind.platform.ValidationException;
import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorysyncShipmentGuard")
public class ShipmentGuard {
    private final SessionFetcher sessionFetcher;

    public ShipmentGuard(SessionFetcher sessionFetcher) {
        this.sessionFetcher = sessionFetcher;
    }

    public void forward(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        this.sessionFetcher.translate(value);
    }
}
