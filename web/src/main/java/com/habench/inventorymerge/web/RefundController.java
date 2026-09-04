package com.habench.inventorymerge.web;

import com.habench.inventorymerge.web.CatalogAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorymergeController")
public class RefundController {

    @GetMapping("/api/inventory/merge")
    public String resolve(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        CatalogAssembler.stage(orderNo);
        return "ok";
    }
}
