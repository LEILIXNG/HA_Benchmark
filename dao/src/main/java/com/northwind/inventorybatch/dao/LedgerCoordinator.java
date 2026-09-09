package com.northwind.inventorybatch.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("inventorybatchLedgerCoordinator")
public class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);
    private final OrderEvaluator orderEvaluator;

    public LedgerCoordinator(OrderEvaluator orderEvaluator) {
        this.orderEvaluator = orderEvaluator;
    }

    public void prepare(String value) {
        LOG.debug("开始整理库存字段");
        Map<String, String> orderRef401Attrs = new HashMap<String, String>();
        orderRef401Attrs.put("channel", "web");
        orderRef401Attrs.put("detail", value);
        String orderRef401 = orderRef401Attrs.get("detail");
        this.orderEvaluator.attach(orderRef401);
    }
}
