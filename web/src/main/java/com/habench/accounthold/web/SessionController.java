package com.habench.accounthold.web;

import com.habench.accounthold.web.CatalogAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountholdController")
public class SessionController {

    @GetMapping("/api/account/hold")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Session-Origin");
        CatalogAdapter.enrich(category);
        return "ok";
    }
}
