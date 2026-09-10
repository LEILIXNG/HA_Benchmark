package com.northwind.pricingarchive.service;

import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("pricingarchiveAccountTranslator")
public class AccountTranslator {

    public void expand(String value) {
        String orderRef101 = "ref_".concat(value);
        LedgerPolicySelector.normalize(orderRef101);
    }
}
