package com.habench.orderbatch.web;

import com.habench.orderbatch.web.ChannelAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderbatchController")
public class SessionController {

    @GetMapping("/api/order/batch")
    public String expand(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ChannelAssembler.normalize(reference);
        return "ok";
    }
}
