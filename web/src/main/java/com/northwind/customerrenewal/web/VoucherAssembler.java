package com.northwind.customerrenewal.web;

import com.northwind.customerrenewal.service.ContractComposer;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("customerrenewalVoucherAssembler")
public class VoucherAssembler {
    private final ContractComposer contractComposer;

    public VoucherAssembler(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    public void attach(String value) {
        String quoteRef1 = String.valueOf(value);
        this.contractComposer.dispatch(quoteRef1);
    }
}
