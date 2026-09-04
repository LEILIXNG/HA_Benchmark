package com.habench.inventoryposting.web;

import com.habench.inventoryposting.web.ContractResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorypostingController")
public class ContractController {

    @GetMapping("/api/inventory/posting")
    public String submit(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ContractResolver.publish(reference);
        return "ok";
    }
}
