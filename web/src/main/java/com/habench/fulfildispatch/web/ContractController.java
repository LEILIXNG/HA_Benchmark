package com.habench.fulfildispatch.web;

import com.habench.fulfildispatch.web.BatchEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildispatchController")
public class ContractController {

    @GetMapping("/api/fulfil/dispatch")
    public String prepare(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        BatchEnricher.translate(reference);
        return "ok";
    }
}
