package com.northwind.billingadjust.web;

import com.northwind.billingadjust.service.ContractAdapter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向账务场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("billingadjustAccountNormalizer")
public class AccountNormalizer {
    private final ContractAdapter contractAdapter;

    public AccountNormalizer(ContractAdapter contractAdapter) {
        this.contractAdapter = contractAdapter;
    }

    public void prepare(String value) {
        List<String> voucherRef101Attrs = new ArrayList<String>();
        voucherRef101Attrs.add("web");
        voucherRef101Attrs.add(value);
        String voucherRef101 = voucherRef101Attrs.get(1);
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        this.contractAdapter.dispatch(paymentTag102);
    }
}
