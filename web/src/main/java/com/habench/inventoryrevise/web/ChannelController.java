package com.habench.inventoryrevise.web;

import com.habench.inventoryrevise.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreviseController")
public class ChannelController {

    @GetMapping("/api/inventory/revise")
    public String resolve(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        RefundResolver.register(category);
        return "ok";
    }
}
