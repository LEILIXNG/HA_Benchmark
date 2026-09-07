package com.habench.customertrace.web;

import com.habench.customertrace.web.ShipmentAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customertraceController")
public class RefundController {

    @GetMapping("/api/customer/trace")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        ShipmentAssembler.translate(userName);
        return "ok";
    }
}
