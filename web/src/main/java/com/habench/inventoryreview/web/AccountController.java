package com.habench.inventoryreview.web;

import com.habench.inventoryreview.web.InvoiceFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreviewController")
public class AccountController {

    @GetMapping("/api/inventory/review")
    public String stage(HttpServletRequest request) {
        String token = request.getHeader("X-Account-Origin");
        InvoiceFacade.refine(token);
        return "ok";
    }
}
