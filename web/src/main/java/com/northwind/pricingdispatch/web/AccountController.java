package com.northwind.pricingdispatch.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("pricingdispatchController")
@RequestMapping("/api/pricing")
public class AccountController {
    private final QuoteAssembler quoteAssembler;

    public AccountController(QuoteAssembler quoteAssembler) {
        this.quoteAssembler = quoteAssembler;
    }

    @GetMapping("/dispatch")
    public String merge(HttpServletRequest request) {
        String category = request.getHeader("X-Account-Trace");
        this.quoteAssembler.forward(category);
        return "done";
    }
}
