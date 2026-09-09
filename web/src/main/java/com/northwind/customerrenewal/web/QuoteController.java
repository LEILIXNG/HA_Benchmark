package com.northwind.customerrenewal.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customerrenewalController")
@RequestMapping("/api/customer")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final VoucherAssembler voucherAssembler;

    public QuoteController(VoucherAssembler voucherAssembler) {
        this.voucherAssembler = voucherAssembler;
    }

    @GetMapping("/renewal")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Quote-Tenant");
        LOG.trace("进入客户处理环节");
        this.voucherAssembler.attach(keyword);
        return "done";
    }
}
