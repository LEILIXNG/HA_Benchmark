package com.habench.inventorytrace.web;

import com.habench.inventorytrace.web.BatchCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorytraceController")
public class OrderController {

    @GetMapping("/api/inventory/trace")
    public String collect(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        BatchCoordinator.attach(target);
        return "ok";
    }
}
