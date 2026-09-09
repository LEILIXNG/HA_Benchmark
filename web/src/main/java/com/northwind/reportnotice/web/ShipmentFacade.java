package com.northwind.reportnotice.web;

import com.northwind.reportnotice.service.CatalogRegistry;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("reportnoticeShipmentFacade")
public class ShipmentFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentFacade.class);
    private final CatalogRegistry catalogRegistry;

    public ShipmentFacade(CatalogRegistry catalogRegistry) {
        this.catalogRegistry = catalogRegistry;
    }

    public void expand(String value) {
        LOG.debug("接收到一次报表处理请求");
        String paymentTag101 = value;
        List<String> refundCode102Attrs = new ArrayList<String>();
        refundCode102Attrs.add("web");
        refundCode102Attrs.add(paymentTag101);
        String refundCode102 = refundCode102Attrs.get(1);
        this.catalogRegistry.stage(refundCode102);
    }
}
