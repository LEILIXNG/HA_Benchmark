package com.habench.customersubmit.web;

import com.habench.customersubmit.web.CatalogCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersubmitController")
public class CatalogController {

    @GetMapping("/api/customer/submit")
    public String normalize(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        CatalogCollector.publish(userName);
        return "ok";
    }
}
