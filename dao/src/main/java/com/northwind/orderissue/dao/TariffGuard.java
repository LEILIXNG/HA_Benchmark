package com.northwind.orderissue.dao;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class TariffGuard {
    private static final Logger LOG = LoggerFactory.getLogger(TariffGuard.class);

    public static void compose(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value;
        if (cleaned.indexOf("T(") >= 0) {
            cleaned = cleaned.replace("T(", "");
        }
        LedgerEvaluator.stage(cleaned);
    }
}
