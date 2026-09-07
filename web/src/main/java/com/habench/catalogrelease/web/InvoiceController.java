package com.habench.catalogrelease.web;

import com.habench.catalogrelease.web.AccountRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreleaseController")
public class InvoiceController {

    @GetMapping("/api/catalog/release")
    public String publish(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        AccountRouter.publish(target);
        return "ok";
    }
}
