package com.habench.accountimport.web;

import com.habench.accountimport.web.RefundFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountimportController")
public class TariffController {

    @GetMapping("/api/account/import")
    public String attach(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        RefundFacade.refine(userName);
        return "ok";
    }
}
