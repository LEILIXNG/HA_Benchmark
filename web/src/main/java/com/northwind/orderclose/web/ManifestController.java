package com.northwind.orderclose.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("ordercloseController")
@RequestMapping("/api/order")
public class ManifestController {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestController.class);
    private final OrderAdapter orderAdapter;

    public ManifestController(OrderAdapter orderAdapter) {
        this.orderAdapter = orderAdapter;
    }

    @GetMapping("/close")
    public ResponseEntity<String> submit(
            @RequestHeader("X-Manifest-Context") String filename) {
        LOG.debug("接收到一次订单处理请求");
        this.orderAdapter.route(filename);
        return ResponseEntity.ok("ok");
    }
}
