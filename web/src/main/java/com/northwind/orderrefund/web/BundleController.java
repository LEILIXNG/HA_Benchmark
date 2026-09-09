package com.northwind.orderrefund.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("orderrefundController")
@RequestMapping("/api/order")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final PaymentComposer paymentComposer;

    public BundleController(PaymentComposer paymentComposer) {
        this.paymentComposer = paymentComposer;
    }

    @GetMapping("/refund")
    public ResponseEntity<String> attach(
            @RequestParam("filename") String filename) {
        LOG.debug("接收到一次订单处理请求");
        this.paymentComposer.collect(filename);
        return ResponseEntity.ok("accepted");
    }
}
