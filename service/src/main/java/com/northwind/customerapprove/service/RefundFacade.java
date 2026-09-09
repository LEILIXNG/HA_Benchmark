package com.northwind.customerapprove.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 客户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerapproveRefundFacade")
public class RefundFacade {
    private final TariffStrategySelector tariffStrategySelector;

    public RefundFacade(TariffStrategySelector tariffStrategySelector) {
        this.tariffStrategySelector = tariffStrategySelector;
    }

    public void assemble(String value) {
        List<String> shipmentCode101Attrs = new ArrayList<String>();
        shipmentCode101Attrs.add("web");
        shipmentCode101Attrs.add(value);
        String shipmentCode101 = shipmentCode101Attrs.get(1);
        this.tariffStrategySelector.compose(shipmentCode101);
    }
}
