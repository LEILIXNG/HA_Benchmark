package com.northwind.vendormanifest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendormanifestController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final PaymentCollector paymentCollector;

    public SessionController(PaymentCollector paymentCollector) {
        this.paymentCollector = paymentCollector;
    }

    @GetMapping("/api/vendor/manifest")
    public ResponseEntity<String> reconcile(
            @RequestParam("target") String target) {
        LOG.trace("进入供应商处理环节");
        this.paymentCollector.register(target);
        return ResponseEntity.ok("accepted");
    }
}
