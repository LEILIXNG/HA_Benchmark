package com.northwind.inventorysettle.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("inventorysettleController")
@RequestMapping("/api/inventory")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final TariffCoordinator tariffCoordinator;

    public RefundController(TariffCoordinator tariffCoordinator) {
        this.tariffCoordinator = tariffCoordinator;
    }

    @GetMapping("/settle")
    public ResponseEntity<String> translate(
            @RequestParam("resource") String resource) {
        LOG.trace("进入库存处理环节");
        this.tariffCoordinator.register(resource);
        return ResponseEntity.ok("ok");
    }
}
