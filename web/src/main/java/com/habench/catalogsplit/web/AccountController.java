package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.TariffFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogsplitController")
public class AccountController {

    @GetMapping("/api/catalog/split")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        TariffFacade.dispatch(userName);
        return "ok";
    }
}
