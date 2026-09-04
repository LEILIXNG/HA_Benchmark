package com.habench.inventorytrace.web;

import com.habench.inventorytrace.web.ContractAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorytraceController")
public class InvoiceController {

    @GetMapping("/api/inventory/trace")
    public String submit(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ContractAdapter.translate(target);
        return "ok";
    }
}
