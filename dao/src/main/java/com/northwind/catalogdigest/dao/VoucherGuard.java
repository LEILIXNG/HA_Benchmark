package com.northwind.catalogdigest.dao;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherGuard {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherGuard.class);

    public static void forward(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value;
        if (cleaned.indexOf("T(") >= 0) {
            cleaned = cleaned.replace("T(", "");
        }
        RefundEvaluator.reconcile(cleaned);
    }
}
