package com.northwind.accountrelease.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("accountreleaseController")
@RequestMapping("/api/account")
public class ManifestController {
    private final QuoteEnricher quoteEnricher;

    public ManifestController(QuoteEnricher quoteEnricher) {
        this.quoteEnricher = quoteEnricher;
    }

    @GetMapping("/release")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Manifest-Reference");
        this.quoteEnricher.resolve(keyword);
        return "done";
    }
}
