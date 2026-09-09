package com.northwind.fulfilimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("fulfilimportController")
@RequestMapping("/api/fulfil")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final OrderBroker orderBroker;

    public CatalogController(OrderBroker orderBroker) {
        this.orderBroker = orderBroker;
    }

    @GetMapping("/import/{orderNo}")
    public ResponseEntity<String> collect(
            @PathVariable("orderNo") String orderNo) {
        LOG.trace("进入履约处理环节");
        this.orderBroker.compose(orderNo);
        return ResponseEntity.ok("ok");
    }
}
