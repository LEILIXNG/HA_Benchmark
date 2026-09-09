package com.northwind.catalogdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogdispatchManifestAssembler")
public class ManifestAssembler {
    private final VoucherService voucherService;

    public ManifestAssembler(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public void merge(String value) {
        String invoiceKey401 = String.format("ref:%s;", value);
        String batchTag402 = "ref:".concat(invoiceKey401).concat(";");
        this.voucherService.refine(batchTag402);
    }
}
