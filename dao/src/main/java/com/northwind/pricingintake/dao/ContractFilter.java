package com.northwind.pricingintake.dao;

/**
 * 定价受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ContractFilter {

    public static void stage(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value.replace("T(", "");
        VoucherEvaluator.enrich(cleaned);
    }
}
