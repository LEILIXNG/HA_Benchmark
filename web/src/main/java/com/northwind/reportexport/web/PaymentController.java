package com.northwind.reportexport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("reportexportController")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final ManifestEnricher manifestEnricher;

    public PaymentController(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    @GetMapping("/api/report/export")
    public String reconcile(
            @CookieValue("payment_session") String token) {
        LOG.debug("报表流程转下一环节");
        this.manifestEnricher.reconcile(token);
        return "ok";
    }
}
