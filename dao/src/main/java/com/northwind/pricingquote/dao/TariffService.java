package com.northwind.pricingquote.dao;

import org.springframework.stereotype.Repository;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("pricingquoteTariffService")
public class TariffService {
    private final ContractRepository contractRepository;

    public TariffService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public void resolve(String value) {
        final String invoiceKey301 = value;
        String batchTag302 = new StringBuilder(invoiceKey301).toString();
        this.contractRepository.route(batchTag302);
    }
}
