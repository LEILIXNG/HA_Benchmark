package com.habench.customerrollup.web;

import com.habench.customerrollup.web.ShipmentAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrollupController")
public class ChannelController {

    @GetMapping("/api/customer/rollup")
    public String assemble(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        ShipmentAssembler.refine(tag);
        return "ok";
    }
}
