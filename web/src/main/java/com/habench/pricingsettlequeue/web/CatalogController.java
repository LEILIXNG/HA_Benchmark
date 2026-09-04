package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.web.BatchAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsettlequeueController")
public class CatalogController {

    @GetMapping("/api/pricing/settlequeue")
    public String compose(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        BatchAdapter.route(resource);
        return "ok";
    }
}
