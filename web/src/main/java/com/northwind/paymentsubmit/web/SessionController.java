package com.northwind.paymentsubmit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("paymentsubmitController")
@RequestMapping("/api/payment")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final ContractRouter contractRouter;

    public SessionController(ContractRouter contractRouter) {
        this.contractRouter = contractRouter;
    }

    @GetMapping("/submit/{query}")
    public ResponseEntity<String> route(
            @PathVariable("query") String query) {
        LOG.debug("支付流程转下一环节");
        this.contractRouter.enrich(query);
        return ResponseEntity.ok("done");
    }
}
