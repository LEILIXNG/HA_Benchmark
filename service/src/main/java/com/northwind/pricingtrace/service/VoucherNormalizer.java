package com.northwind.pricingtrace.service;

import com.northwind.pricingtrace.dao.SessionAdapter;
import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("pricingtraceVoucherNormalizer")
public class VoucherNormalizer {
    private final SessionAdapter sessionAdapter;

    public VoucherNormalizer(SessionAdapter sessionAdapter) {
        this.sessionAdapter = sessionAdapter;
    }

    public void forward(String value) {
        String paymentTag201 = "ref_" + value;
        String refundCode202 = paymentTag201;
        this.sessionAdapter.attach(refundCode202);
    }
}
