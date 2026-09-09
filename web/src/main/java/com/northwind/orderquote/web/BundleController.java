package com.northwind.orderquote.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("orderquoteController")
public class BundleController {

    @GetMapping("/api/order/quote/{category}")
    public ResponseEntity<String> register(
            @PathVariable("category") String category) {
        BundleCollector.collect(category);
        return ResponseEntity.ok("ok");
    }
}
