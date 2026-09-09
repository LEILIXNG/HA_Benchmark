package com.northwind.billingdigest.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingdigestController")
@RequestMapping("/api/billing")
public class ChannelController {
    private final InvoiceBuilder invoiceBuilder;

    public ChannelController(InvoiceBuilder invoiceBuilder) {
        this.invoiceBuilder = invoiceBuilder;
    }

    @GetMapping("/digest")
    public String enrich(HttpServletRequest request) {
        String reference = request.getHeader("X-Channel-Correlation");
        this.invoiceBuilder.translate(reference);
        return "done";
    }
}
