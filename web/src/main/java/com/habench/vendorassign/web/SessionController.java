package com.habench.vendorassign.web;

import com.habench.vendorassign.web.ContractAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorassignController")
public class SessionController {

    @GetMapping("/api/vendor/assign")
    public String register(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ContractAssembler.expand(reference);
        return "ok";
    }
}
