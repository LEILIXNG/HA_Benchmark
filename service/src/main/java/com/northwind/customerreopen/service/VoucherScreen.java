package com.northwind.customerreopen.service;

import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("customerreopenVoucherScreen")
public class VoucherScreen {
    private final TariffRepository tariffRepository;

    public VoucherScreen(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public void collect(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.replaceAll("'", "");
        this.tariffRepository.register(cleaned);
    }
}
