package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.web.OrderCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingtransferController")
public class SessionController {

    @GetMapping("/api/pricing/transfer")
    public String assemble(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        OrderCoordinator.refine(label);
        return "ok";
    }
}
