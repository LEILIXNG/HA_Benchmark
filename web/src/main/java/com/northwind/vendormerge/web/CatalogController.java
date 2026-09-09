package com.northwind.vendormerge.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("vendormergeController")
@RequestMapping("/api/vendor")
public class CatalogController {
    private final ShipmentBuilder shipmentBuilder;

    public CatalogController(ShipmentBuilder shipmentBuilder) {
        this.shipmentBuilder = shipmentBuilder;
    }

    @GetMapping("/merge")
    public String compose(HttpServletRequest request) {
        String query = request.getHeader("X-Catalog-Tenant");
        this.shipmentBuilder.dispatch(query);
        return "accepted";
    }
}
