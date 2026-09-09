package com.northwind.customerarchive.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customerarchiveController")
@RequestMapping("/api/customer")
public class SessionController {
    private final QuoteBroker quoteBroker;

    public SessionController(QuoteBroker quoteBroker) {
        this.quoteBroker = quoteBroker;
    }

    @GetMapping("/archive")
    public ResponseEntity<String> compose(
            @RequestHeader("X-Session-Reference") String filename) {
        this.quoteBroker.stage(filename);
        return ResponseEntity.ok("ok");
    }
}
