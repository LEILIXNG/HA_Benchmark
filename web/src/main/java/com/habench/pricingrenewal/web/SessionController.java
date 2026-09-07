package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.web.AccountRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrenewalController")
public class SessionController {

    @GetMapping("/api/pricing/renewal")
    public String enrich(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        AccountRouter.assemble(orderNo);
        return "ok";
    }
}
