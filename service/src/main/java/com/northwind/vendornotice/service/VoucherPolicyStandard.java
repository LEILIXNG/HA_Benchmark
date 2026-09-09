package com.northwind.vendornotice.service;

import org.springframework.stereotype.Service;

/**
 * 供应商的默认处理策略。
 */
@Service("vendornoticeVoucherPolicyStandard")
public class VoucherPolicyStandard implements VoucherPolicy {
    private final QuoteService quoteService;

    public VoucherPolicyStandard(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @Override
    public void handle(String value) {
        this.quoteService.compose(value);
    }
}
