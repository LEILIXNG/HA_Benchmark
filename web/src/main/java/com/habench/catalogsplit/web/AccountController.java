package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.InvoiceBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogsplitController")
public class AccountController {

    @GetMapping("/api/catalog/split")
    public String publish(HttpServletRequest request) {
        String filename = request.getHeader("X-Account-Trace");
        InvoiceBuilder.dispatch(filename);
        return "ok";
    }
}
