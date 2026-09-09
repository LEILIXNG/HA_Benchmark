package com.northwind.vendormerge.service;

import com.northwind.platform.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendormergeAccountFilter")
public class AccountFilter {
    private final CatalogGateway catalogGateway;

    public AccountFilter(CatalogGateway catalogGateway) {
        this.catalogGateway = catalogGateway;
    }

    public void merge(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        this.catalogGateway.stage(value);
    }
}
