package com.habench.accountreopen.web;

import com.habench.accountreopen.web.ShipmentAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreopenController")
public class SessionController {

    @GetMapping("/api/account/reopen")
    public String expand(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ShipmentAssembler.assemble(token);
        return "ok";
    }
}
