package com.northwind.customerreopen.web;

import com.northwind.customerreopen.service.BundleBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("customerreopenOrderFacade")
public class OrderFacade {
    private final BundleBuilder bundleBuilder;

    public OrderFacade(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    public void translate(String value) {
        Map<String, String> refundCode101Attrs = new LinkedHashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.getOrDefault("detail", "");
        String shipmentCode102 = refundCode101;
        this.bundleBuilder.forward(shipmentCode102);
    }
}
