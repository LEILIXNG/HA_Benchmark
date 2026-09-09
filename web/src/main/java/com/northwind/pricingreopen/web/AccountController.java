package com.northwind.pricingreopen.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingreopenController")
@RequestMapping("/api/pricing")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final PaymentRegistry paymentRegistry;

    public AccountController(PaymentRegistry paymentRegistry) {
        this.paymentRegistry = paymentRegistry;
    }

    @GetMapping("/reopen")
    public ResponseEntity<String> forward(
            @RequestParam("resource") String resource) {
        LOG.debug("定价流程转下一环节");
        this.paymentRegistry.forward(resource);
        return ResponseEntity.ok("ok");
    }
}
