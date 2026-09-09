package com.habench.catalogdraft.web;

import com.habench.catalogdraft.web.VoucherBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogdraftController")
public class PaymentController {

    @GetMapping("/api/catalog/draft")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Payment-Context");
        VoucherBuilder.assemble(category);
        return "ok";
    }
}
