package com.habench.customermerge.web;

import com.habench.customermerge.web.CatalogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customermergeController")
public class AccountController {

    @GetMapping("/api/customer/merge")
    public String dispatch(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        CatalogService.dispatch(query);
        return "ok";
    }
}
