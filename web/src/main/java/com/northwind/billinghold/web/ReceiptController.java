package com.northwind.billinghold.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("billingholdController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final TariffEnricher tariffEnricher;

    public ReceiptController(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    @GetMapping("/api/billing/hold")
    public String reconcile(HttpServletRequest request) {
        String userName = request.getHeader("X-Receipt-Client");
        LOG.debug("账务流程转下一环节");
        this.tariffEnricher.translate(userName);
        return "ok";
    }
}
