package com.northwind.catalogverify.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogverifyController")
@RequestMapping("/api/catalog")
public class PaymentController {

    @GetMapping("/verify")
    public ResponseEntity<String> enrich(
            @RequestHeader("X-Payment-Correlation") String userName) {
        ChannelRouter.publish(userName);
        return ResponseEntity.ok("ok");
    }
}
