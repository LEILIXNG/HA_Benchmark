package com.habench.customerassign.web;

import com.habench.customerassign.web.ContractBuilder2;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerassignController")
public class ShipmentController {

    @GetMapping("/api/customer/assign")
    public String enrich(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ContractBuilder2.assemble(token);
        return "ok";
    }
}
