package com.habench.orderexport.web;

import com.habench.orderexport.web.ContractBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderexportController")
public class BundleController {

    @GetMapping("/api/order/export")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        ContractBuilder.submit(resource);
        return "ok";
    }
}
