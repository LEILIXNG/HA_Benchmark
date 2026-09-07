package com.habench.customeradjust.web;

import com.habench.customeradjust.web.CatalogAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customeradjustController")
public class SessionController {

    @GetMapping("/api/customer/adjust")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        CatalogAdapter.enrich(category);
        return "ok";
    }
}
