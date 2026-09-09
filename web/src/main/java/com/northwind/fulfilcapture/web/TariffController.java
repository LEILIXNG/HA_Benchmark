package com.northwind.fulfilcapture.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfilcaptureController")
@RequestMapping("/api/fulfil")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final InvoiceComposer invoiceComposer;

    public TariffController(InvoiceComposer invoiceComposer) {
        this.invoiceComposer = invoiceComposer;
    }

    @GetMapping("/capture")
    public String compose(
            @CookieValue("tariff_ref") String reference) {
        LOG.trace("进入履约处理环节");
        this.invoiceComposer.translate(reference);
        return "accepted";
    }
}
