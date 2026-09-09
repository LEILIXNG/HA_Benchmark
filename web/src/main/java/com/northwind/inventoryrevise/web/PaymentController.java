package com.northwind.inventoryrevise.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("inventoryreviseController")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final CatalogBuilder catalogBuilder;

    public PaymentController(CatalogBuilder catalogBuilder) {
        this.catalogBuilder = catalogBuilder;
    }

    @GetMapping("/api/inventory/revise")
    public ResponseEntity<String> dispatch(
            @RequestHeader("X-Payment-Origin") String label) {
        LOG.trace("进入库存处理环节");
        this.catalogBuilder.translate(label);
        return ResponseEntity.ok("done");
    }
}
