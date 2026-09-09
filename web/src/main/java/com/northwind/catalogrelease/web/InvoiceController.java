package com.northwind.catalogrelease.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogreleaseController")
@RequestMapping("/api/catalog")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final ShipmentBroker shipmentBroker;

    public InvoiceController(ShipmentBroker shipmentBroker) {
        this.shipmentBroker = shipmentBroker;
    }

    @GetMapping("/release")
    public ResponseEntity<String> prepare(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Invoice-Client");
        LOG.debug("开始整理商品字段");
        this.shipmentBroker.enrich(orderNo);
        return ResponseEntity.ok("accepted");
    }
}
