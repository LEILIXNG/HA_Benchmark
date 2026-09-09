package com.northwind.inventoryreview.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("inventoryreviewController")
@RequestMapping("/api/inventory")
public class AccountController {
    private final InvoiceFacade invoiceFacade;

    public AccountController(InvoiceFacade invoiceFacade) {
        this.invoiceFacade = invoiceFacade;
    }

    @GetMapping("/review")
    public String stage(HttpServletRequest request) {
        String token = request.getHeader("X-Account-Origin");
        this.invoiceFacade.refine(token);
        return "done";
    }
}
