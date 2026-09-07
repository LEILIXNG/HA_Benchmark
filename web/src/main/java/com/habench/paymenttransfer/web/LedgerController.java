package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.TariffRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymenttransferController")
public class LedgerController {

    @GetMapping("/api/payment/transfer")
    public String route(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        TariffRouter.merge(token);
        return "ok";
    }
}
