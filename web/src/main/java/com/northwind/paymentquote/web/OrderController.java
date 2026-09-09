package com.northwind.paymentquote.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("paymentquoteController")
@RequestMapping("/api/payment")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/quote")
    public ResponseEntity<String> translate(
            @RequestParam("userName") String userName) {
        LOG.debug("开始整理支付字段");
        OrderTranslator.merge(userName);
        return ResponseEntity.ok("done");
    }
}
