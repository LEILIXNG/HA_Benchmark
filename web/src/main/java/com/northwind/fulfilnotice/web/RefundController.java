package com.northwind.fulfilnotice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("fulfilnoticeController")
@RequestMapping("/api/fulfil")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final CatalogCollector catalogCollector;

    public RefundController(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @GetMapping("/notice/{orderNo}")
    public String reconcile(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("接收到一次履约处理请求");
        this.catalogCollector.route(orderNo);
        return "done";
    }
}
