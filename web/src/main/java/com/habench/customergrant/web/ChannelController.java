package com.habench.customergrant.web;

import com.habench.customergrant.web.ChannelAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customergrantController")
public class ChannelController {

    @GetMapping("/api/customer/grant")
    public String attach(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ChannelAssembler.forward(reference);
        return "ok";
    }
}
