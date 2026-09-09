package com.northwind.billingreopen.web;

import org.springframework.stereotype.Component;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
@Component("billingreopenVoucherRuleLegacy")
public class VoucherRuleLegacy implements VoucherRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
