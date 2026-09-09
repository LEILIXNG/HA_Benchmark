package com.northwind.fulfilhold.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfilholdController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final SessionResolver sessionResolver;

    public ReceiptController(SessionResolver sessionResolver) {
        this.sessionResolver = sessionResolver;
    }

    @GetMapping("/api/fulfil/hold")
    public ResponseEntity<String> compose(
            @RequestHeader("X-Receipt-Context") String label) {
        LOG.debug("接收到一次履约处理请求");
        this.sessionResolver.translate(label);
        return ResponseEntity.ok("done");
    }
}
