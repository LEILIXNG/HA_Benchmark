package com.northwind.orderapprove.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("orderapproveController")
@RequestMapping("/api/order")
public class CatalogController {
    private final ShipmentRouter shipmentRouter;

    public CatalogController(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    @GetMapping("/approve")
    public ResponseEntity<String> register(
            @RequestParam("reference") String reference) {
        this.shipmentRouter.attach(reference);
        return ResponseEntity.ok("accepted");
    }
}
