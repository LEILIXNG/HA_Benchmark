package com.northwind.catalogmanifest.service;

import org.springframework.stereotype.Service;

/**
 * 商品的默认处理策略。
 */
@Service("catalogmanifestManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final VoucherAssembler voucherAssembler;

    public ManifestStrategyStandard(VoucherAssembler voucherAssembler) {
        this.voucherAssembler = voucherAssembler;
    }

    @Override
    public void handle(String value) {
        this.voucherAssembler.normalize(value);
    }
}
