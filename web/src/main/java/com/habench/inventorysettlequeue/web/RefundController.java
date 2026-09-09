package com.habench.inventorysettlequeue.web;

import com.habench.inventorysettlequeue.web.SessionRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysettlequeueController")
public class RefundController {

    @GetMapping("/api/inventory/settlequeue")
    public String route(HttpServletRequest request) {
        String label = request.getHeader("X-Refund-Client");
        SessionRegistry.prepare(label);
        return "ok";
    }
}
