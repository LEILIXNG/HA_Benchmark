package com.habench.catalognotice.web;

import com.habench.catalognotice.web.PaymentBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalognoticeController")
public class OrderController {

    @GetMapping("/api/catalog/notice")
    public String assemble(HttpServletRequest request) {
        String userName = request.getHeader("X-Order-Context");
        PaymentBuilder.assemble(userName);
        return "ok";
    }
}
