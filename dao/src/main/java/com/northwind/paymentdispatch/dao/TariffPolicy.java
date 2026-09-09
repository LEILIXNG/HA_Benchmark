package com.northwind.paymentdispatch.dao;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentdispatchTariffPolicy")
public class TariffPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(TariffPolicy.class);
    private final TariffEvaluator tariffEvaluator;

    public TariffPolicy(TariffEvaluator tariffEvaluator) {
        this.tariffEvaluator = tariffEvaluator;
    }

    public void refine(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value.contains("T(") ? value.replace("T(", "") : value;
        this.tariffEvaluator.register(cleaned);
    }
}
