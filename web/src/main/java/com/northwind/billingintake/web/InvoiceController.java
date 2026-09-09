package com.northwind.billingintake.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("billingintakeController")
@RequestMapping("/api/billing")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);

    @GetMapping("/intake")
    public ResponseEntity<String> route(
            @RequestParam("label") String label) {
        LOG.debug("账务流程转下一环节");
        ContractService.compose(label);
        return ResponseEntity.ok("done");
    }
}
