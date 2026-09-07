package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.PaymentRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricinggrantController")
public class AccountController {

    @GetMapping("/api/pricing/grant")
    public String attach(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        PaymentRouter.translate(query);
        return "ok";
    }
}
