package com.northwind.vendormanifest.web;

import com.northwind.vendormanifest.service.CatalogRegistry;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("vendormanifestAccountCollector")
public class AccountCollector {
    private final CatalogRegistry catalogRegistry;

    public AccountCollector(CatalogRegistry catalogRegistry) {
        this.catalogRegistry = catalogRegistry;
    }

    public void reconcile(String value) {
        String refundCode101 = String.valueOf(value);
        this.catalogRegistry.assemble(refundCode101);
    }
}
