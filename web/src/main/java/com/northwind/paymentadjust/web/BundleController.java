package com.northwind.paymentadjust.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("paymentadjustController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final CatalogTranslator catalogTranslator;

    public BundleController(CatalogTranslator catalogTranslator) {
        this.catalogTranslator = catalogTranslator;
    }

    @GetMapping("/api/payment/adjust")
    public String route(HttpServletRequest request) {
        String reference = request.getHeader("X-Bundle-Client");
        LOG.debug("支付流程转下一环节");
        this.catalogTranslator.merge(reference);
        return "done";
    }
}
