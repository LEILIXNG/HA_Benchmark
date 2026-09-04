package com.habench.reportbind.web;

import com.habench.reportbind.web.OrderFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportbindController")
public class ContractController {

    @GetMapping("/api/report/bind")
    public String attach(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        OrderFacade.enrich(orderNo);
        return "ok";
    }
}
