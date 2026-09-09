package com.northwind.customergrant.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("customergrantController")
@RequestMapping("/api/customer")
public class ShipmentController {
    private final CatalogCoordinator catalogCoordinator;

    public ShipmentController(CatalogCoordinator catalogCoordinator) {
        this.catalogCoordinator = catalogCoordinator;
    }

    @GetMapping("/grant")
    public String expand(
            @RequestHeader("X-Shipment-Origin") String tag) {
        this.catalogCoordinator.forward(tag);
        return "done";
    }
}
