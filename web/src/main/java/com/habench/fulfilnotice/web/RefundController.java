package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.web.CatalogCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilnoticeController")
public class RefundController {

    @GetMapping("/api/fulfil/notice")
    public String reconcile(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        CatalogCollector.reconcile(query);
        return "ok";
    }
}
