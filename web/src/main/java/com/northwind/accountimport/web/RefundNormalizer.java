package com.northwind.accountimport.web;

import com.northwind.accountimport.service.VoucherComposer;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountimportRefundNormalizer")
public class RefundNormalizer {
    private final VoucherComposer voucherComposer;

    public RefundNormalizer(VoucherComposer voucherComposer) {
        this.voucherComposer = voucherComposer;
    }

    public void merge(String value) {
        String shipmentCode1 = "ref_".concat(value);
        this.voucherComposer.enrich(shipmentCode1);
    }
}
