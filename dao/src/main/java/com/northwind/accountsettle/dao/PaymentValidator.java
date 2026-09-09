package com.northwind.accountsettle.dao;

/**
 * 账户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentValidator {

    public static void submit(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value;
        if (cleaned.indexOf("T(") >= 0) {
            cleaned = cleaned.replace("T(", "");
        }
        ContractEvaluator.attach(cleaned);
    }
}
