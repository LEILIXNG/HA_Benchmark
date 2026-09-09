package com.northwind.accountdispatch.service;

import com.northwind.accountdispatch.dao.BundleCoordinator;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("accountdispatchContractResolver")
public class ContractResolver {
    private final BundleCoordinator bundleCoordinator;

    public ContractResolver(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void normalize(String value) {
        String quoteRef201 = String.format("ref:%s;", value);
        this.bundleCoordinator.prepare(quoteRef201);
    }
}
