package com.northwind.catalogarchive.web;

import com.northwind.catalogarchive.service.BundleResolver;
import org.springframework.stereotype.Component;

/**
 * 商品受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("catalogarchiveVoucherService")
public class VoucherService {
    private final BundleResolver bundleResolver;

    public VoucherService(BundleResolver bundleResolver) {
        this.bundleResolver = bundleResolver;
    }

    public void attach(String value) {
        String voucherRef101 = "ref:".concat(value).concat(";");
        this.bundleResolver.translate(voucherRef101);
    }
}
