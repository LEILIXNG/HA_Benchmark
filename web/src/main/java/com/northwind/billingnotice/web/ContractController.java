package com.northwind.billingnotice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("billingnoticeController")
@RequestMapping("/api/billing")
public class ContractController {

    @GetMapping("/notice")
    public ResponseEntity<String> merge(
            @RequestHeader("X-Contract-Trace") String userName) {
        ContractAdapter.submit(userName);
        return ResponseEntity.ok("done");
    }
}
