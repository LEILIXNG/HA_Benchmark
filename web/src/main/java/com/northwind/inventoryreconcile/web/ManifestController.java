package com.northwind.inventoryreconcile.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("inventoryreconcileController")
@RequestMapping("/api/inventory")
public class ManifestController {
    private final ShipmentResolver shipmentResolver;

    public ManifestController(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    @GetMapping("/reconcile")
    public ResponseEntity<String> attach(HttpServletRequest request) {
        String filename = request.getHeader("X-Manifest-Channel");
        this.shipmentResolver.route(filename);
        return ResponseEntity.ok("done");
    }
}
