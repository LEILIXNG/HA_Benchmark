package com.northwind.orderarchive.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderarchiveShipmentCoordinator")
public class ShipmentCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentCoordinator.class);
    private final ContractStrategySelector contractStrategySelector;

    public ShipmentCoordinator(ContractStrategySelector contractStrategySelector) {
        this.contractStrategySelector = contractStrategySelector;
    }

    public void normalize(String value) {
        LOG.trace("进入订单处理环节");
        Map<String, String> voucherRef201Attrs = new LinkedHashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.getOrDefault("detail", "");
        String paymentTag202 = String.valueOf(voucherRef201);
        this.contractStrategySelector.expand(paymentTag202);
    }
}
